package simpletable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maroun
 */
public class Row {
    
    // default decoration
    private String rowSeparator = "-";
    private String titleRowSeparator = "=";    
    private String columnSeparator = "|";
    private String corner = "+";
    
    private boolean title = false;
    
    private List<Object> row = new ArrayList<>();
    
    public Row(Object... objects) {
        for (Object object : objects) {
            row.add(object.toString());
        }
    }
    
    
    // mutators //
    
    public String getRowSeparator() {
        return title ? titleRowSeparator : rowSeparator;
    }
    
    public Row setRowSeparator(String rowSeparator) {
        this.rowSeparator = rowSeparator;
        return this;
    }
    
    public String getColumnSeparator() {
        return columnSeparator;
    }
    
    public Row setColumnSeparator(String columnSeparator) {
        this.columnSeparator = columnSeparator;
        return this;
    }
    
    public String getCorner() {
        return corner;
    }
    
    public Row setCorner(String corner) {
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
}
