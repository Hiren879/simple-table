package simpletable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Table {
	
	private ArrayList<List<Object>> rows;
	
	private String rowSeparator = "-";
	private String columnSeparator = "|";
	private String corner = "+";
	
	// TODO: implement title decoration
	private boolean isTitle = false;


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
	 * Table table = new Table();
	 * table.addRow("1", 2);
	 * table.addRow("3", 4, '5');
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
	public Table() {
		rows = new ArrayList<>();
	}


	/**
	 * Adds a row of varargs objects to the table.
	 * @param objects The objects to be added.
	 */
	public void addRow(Object... objects) {
		List<Object> row = new ArrayList<>();
		for (Object object : objects) {
			row.add(object.toString());
		}
		rows.add(row);			
	}


	/**
	 * Fills missing cells with an empty strings.
	 */
	private void fillMissingCells() {
		int longest = getLongestRowSize();
		
		for (List<Object> row : this.rows) {
			if (row.size() < longest) {
				int rowSize = row.size();
				for (int i = 0; i < longest - rowSize; i++) {
					row.add("");
				}
			}
		}
	}


	/**
	 * Builds the row's border according to <code>sizes</code>.
	 * 
	 * @param	sizes Array of column's sizes.
	 * @return	A string that represents the row's border.
	 */
	private String getBorder(int[] sizes) {
		StringBuilder sb = new StringBuilder();
		sb.append(this.corner);
		
		for (int size : sizes) {
			for (int i = 0; i < size + 2; i++) {
				sb.append(this.rowSeparator);
			}
			sb.append(this.corner);
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
		
		for (List<Object> row : this.rows) {			
			for (int i = 0; i < row.size(); i++) {
				int cellSize = row.get(i).toString().length();
				if ( cellSize > res[i]) {
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
		return this.rows.stream().max(Comparator.comparingInt(List::size)).get().size();
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int[] sizes = getSizesArray();
		
		fillMissingCells();
		
		sb.append(getBorder(sizes));
				
		for (List<Object> row : this.rows) {
			sb.append(this.columnSeparator + " ");
			for (int i = 0; i < row.size(); i++) {
				sb.append(row.get(i).toString());
				int appendSpaces = sizes[i] - row.get(i).toString().length();
				for (int j = 0; j < appendSpaces; j++) {
					sb.append(" ");
				}
				sb.append(" " + this.columnSeparator+ " ");
			}
			sb.append("\n");
			sb.append(getBorder(sizes));
		}
		return sb.toString();
	}


	// mutators //
	
	public void setRowSeparator(String rowSeparator) {
		this.rowSeparator = rowSeparator;
	}
	
	public String getRowSeparator() {
		return this.rowSeparator;
	}
	
	public void setColumnSeparator(String columnSeparator) {
		this.columnSeparator = columnSeparator;
	}
	
	public String getColumnSeparator() {
		return this.columnSeparator;
	}
	
	public void setCorner(String corner) {
		this.corner = corner;
	}
	
	public String getCorner() {
		return this.corner;
	}

	public boolean isTitle() {
		return isTitle;
	}
	
	public void setTitle(boolean isTitle) {
		this.isTitle = isTitle;
	}

}
