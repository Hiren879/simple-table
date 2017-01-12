# Simple Table
Because it should be very simple to create simple tables in Java. 

#### Usage Example

```java
  public class UsageExample {
  
	public static void main(String[] args) {
		Table table = new Table();
		table.addRow("1", 2);
		table.addRow("Three", 4, '5');
		
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
  - Change row separator
  - Change colum separator
  - Change border char (the "+" in the example)

#### (Near) Future Work
  - Support nested tables
  - Support padding and advanced formatting
  - Support title decoration
  - ...
