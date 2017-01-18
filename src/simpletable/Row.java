package simpletable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maroun
 */
public class Row {
    
    // default decoration
    private char rowSeparator = '-';
    private char titleRowSeparator = '=';    
    private char columnSeparator = '|';
    private char corner = '+';
    
    private boolean title = false;
    
    private List<Object> row = new ArrayList<>();
    
    public Row(Object... objects) {
        for (Object object : objects) {
            row.add(object.toString());
        }
    }
    
    
    // mutators //
    
    public char getRowSeparator() {
        return title ? titleRowSeparator : rowSeparator;
    }
    
    public Row setRowSeparator(char rowSeparator) {
        this.rowSeparator = rowSeparator;
        return this;
    }
    
    public char getColumnSeparator() {
        return columnSeparator;
    }
    
    public Row setColumnSeparator(char columnSeparator) {
        this.columnSeparator = columnSeparator;
        return this;
    }
    
    public char getCorner() {
        return corner;
    }
    
    public Row setCorner(char corner) {
        this.corner = corner;
        return this;
    }
    
    public List<Object> getRowContent() {
        return this.row;
    }
    
    public Row setTitle() {
        this.title = true;
        return this;
    }
    
    public int size() {
    	return row.size();
    }

}
