# Simple Table
Because it should be very simple to create simple tables in Java. 

#### Usage Example

```java
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
  ```

You can also:
  - Change row and column separators
  - Change border char
  - Set title row(s)
  
More examples:

```java
Table table = new Table();
table.addRow(new Row("Name", "ID").setTitle());
table.addRow(new Row("Maroun", 12113));
table.addRow(new Row("Peter", 31132));
table.addRow(new Row("John", 13552));

+========+=======+
| Name   | ID    | 
+========+=======+
| Maroun | 12113 | 
+--------+-------+
| Peter  | 31132 | 
+--------+-------+
| John   | 13552 | 
+--------+-------+

```

#### (Near) Future Work
  - Support nested tables
  - Support padding and advanced formatting
  - ...
