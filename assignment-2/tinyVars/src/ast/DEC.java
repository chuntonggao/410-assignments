package ast;

import java.util.*;

public class DEC extends STATEMENT {
    private String name;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("new");
        name = tokenizer.getNext();
    }

    @Override
    public Integer evaluate(Map<String, Object> symbolTable) {
        System.out.println("Putting " + this.name + " into symbol table");
        symbolTable.put(name,null); // no value yet; use null as a placeholder
        return null;
    }
}
