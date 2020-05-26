package ast;

import java.util.*;

public class NAME extends EXP {
    private String name;

    @Override
    public void parse() {
        name = tokenizer.getAndCheckNext("[a-z]+");
    }

    @Override
    public Integer evaluate(Map<String, Object> symbolTable) {
        return (Integer) symbolTable.get(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
