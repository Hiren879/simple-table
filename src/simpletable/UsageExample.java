package simpletable;

public class UsageExample {

    public static void main(String[] args) {
        SimpleTable table = new SimpleTable();
        table.addRows(
                new Row("1", 2),
                new Row("Three", 4, '5')
        );
        
        System.out.println(table);
        
        // +-------+---+---+
        // | 1     | 2 |   | 
        // +-------+---+---+
        // | Three | 4 | 5 | 
        // +-------+---+---+
    }
    
}
