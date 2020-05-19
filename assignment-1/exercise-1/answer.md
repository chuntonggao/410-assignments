```java
public void parse() {
	tokenizer.getAndCheckNext("Table:");

	// Parse BoldRow
	BOLDROW boldRow = new BOLDROW();
	boldRow.parse();
	rows.add(boldRow);

	// Parse Rows
	while (tokenizer.moreTokens() && 
	!tokenizer.checkToken("Table:")){
		ROW row = new ROW();
		row.parse();
		rows.add(row);
	}
}
```

Take the `parse` method from `TABLE` as an example. The parsing strategy discussed in class is top-down because in every node's `parse` method (e.g. in `TABLE` in this case), we recursively invoke the `parse` method of its **child** node (e.g. `ROW` in this case). The parser always moves from higher-level elements to lower-level elements, so there is no backtracking involved, hence top-down.

