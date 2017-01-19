package simpletable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SimpleTable {
    
    private ArrayList<Row> rows;


    /**
     * Construct a new <code>Table</code> with default
     * structure:
     * <p>
     * <li> <b>|</b> as the column separator,
     * <li> <b>-</b> as the row separator,
     * <li> <b>+</b> as the corner char.
     * 
     * Example:
     * 
     * <pre>
     * SimpleTable table = new SimpleTable();
     * table.addRow(new Row("1", 2));
     * table.addRow(new Row("3", 4, '5'));
     * System.out.println(table);
     * </pre>
     * 
     * Produces:
     * 
     * <pre>
     * +---+---+---+
     * | 1 | 2 |   | 
     * +---+---+---+
     * | 3 | 4 | 5 | 
     * +---+---+---+
     * </pre>
     */
    public SimpleTable() {
        rows = new ArrayList<>();
    }
    

    /**
     * Adds a row of varargs objects to the table.
     * @param row The row to be added.
     */
    public void addRows(Row... rows) {
        for (Row row: rows)
            this.rows.add(row);
    }


    /**
     * Fills missing cells with an empty strings.
     */
    private void fillMissingCells() {
        int longest = getLongestRowSize();
        
        for (Row row : this.rows) {
            if (row.getRowContent().size() < longest) {
                int rowSize = row.getRowContent().size();
                for (int i = 0; i < longest - rowSize; i++) {
                    row.getRowContent().add("");
                }
            }
        }
    }


    /**
     * Builds the given row border according to <code>sizes</code>.
     * 
     * @param    sizes Array of column's sizes.
     * @param    row   The row we want to get its border.
     * @return   A string that represents the row's border.
     */
    private String getBorder(int[] sizes, Row row) {
        StringBuilder sb = new StringBuilder();
        sb.append(row.getCorner());
        
        for (int size : sizes) {
            for (int i = 0; i < size + 2; i++) {
                sb.append(row.getRowSeparator());
            }
            sb.append(row.getCorner());
        }
        sb.append("\n");
        
        return sb.toString();
    }


    /**
     * Calculates and returns the desired size of each cell 
     * by checking the biggest size of each <i>column</i>.
     * 
     * @return Array that contains the size of each column in the table.
     */
    private int[] getSizesArray() {
        int longestRow = getLongestRowSize();
        int res[] = new int[longestRow];
        Arrays.fill(res, 0);
        
        for (Row row : this.rows) {    
            for (int i = 0; i < row.getRowContent().size(); i++) {
                int cellSize = row.getRowContent().get(i).toString().length();
                if (cellSize > res[i]) {
                    res[i] = cellSize;
                }
            }
        }
        return res;
    }


    /**
     * Returns the longest <i>row</i> size in the table.
     * 
     * @return The longest row size in the table.
     */
    private int getLongestRowSize() {
      return this.rows.stream()
            .max(Comparator.comparing(Row::size))
            .get()
            .getRowContent().size();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int[] sizes = getSizesArray();
        
        fillMissingCells();
        
        sb.append(getBorder(sizes, this.rows.get(0)));
                
        for (Row row : this.rows) {
            List<Object> content = row.getRowContent();
            sb.append(row.getColumnSeparator() + " ");
            for (int i = 0; i < content.size(); i++) {
                sb.append(content.get(i).toString());
                int appendSpaces = sizes[i] - content.get(i).toString().length();
                for (int j = 0; j < appendSpaces; j++) {
                    sb.append(" ");
                }
                sb.append(" " + row.getColumnSeparator() + " ");
            }
            sb.append("\n");
            sb.append(getBorder(sizes, row));
        } 
        return sb.toString();
    }
    
}
