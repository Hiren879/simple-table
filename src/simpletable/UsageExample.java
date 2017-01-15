package simpletable;

public class UsageExample {

    public static void main(String[] args) {
        SimpleTable table = new SimpleTable();
        table.addRow(new Row("1", 2));
        table.addRow(new Row("Three", 4, '5'));
        
        System.out.println(table);
        // +-------+---+---+
        // | 1     | 2 |   | 
        // +-------+---+---+
        // | Three | 4 | 5 | 
        // +-------+---+---+
    }
    
}
