package ast;

import java.util.*;

public class SET extends STATEMENT {
    private String name;
    private EXP exp;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("set");
        name = tokenizer.getNext();
        tokenizer.getAndCheckNext(",");
        exp = exp.makeExp(tokenizer);
        exp.parse();
    }

    @Override
    public Integer evaluate(Map<String, Object> symbolTable) {
        System.out.println("Evaluating " + exp);
        Integer result = exp.evaluate(symbolTable);
        System.out.println("Setting " + name + " to " + result);

        symbolTable.put(name, result);
        return null; // we only return a value for expressions (EXP); evaluation of statements is via side-effects
    }
}
