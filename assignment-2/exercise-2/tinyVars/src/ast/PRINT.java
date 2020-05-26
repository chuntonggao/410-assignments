package ast;

import java.util.*;

public class PRINT extends STATEMENT {
    private EXP printed;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("print");
        printed = EXP.makeExp(tokenizer);
        printed.parse();
    }

    @Override
    public Integer evaluate(Map<String, Object> symbolTable) {
        System.out.println("PRINTING: " + printed.evaluate(symbolTable));
        return null; // we only return a value for expressions (EXP); evaluation of statements is via side-effects
    }
}
