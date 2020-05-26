package ast;

import libs.Node;
import java.util.*;

public class PROCDEF extends Node {
    private String name;
    private PROCBODY procBody;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("def");
        name = tokenizer.getNext();
        procBody = (PROCBODY) EXP.makeExp(tokenizer);
        if (!(procBody instanceof PROCBODY)) {
            throw new RuntimeException("Expect a procedure body, but get: " + procBody.toString());
        }
        procBody.parse();
    }

    @Override
    public Integer evaluate(Map<String, Object> symbolTable) {
        System.out.println("Define procedure " + this.name + " and put into symbol table");
        symbolTable.put(name, procBody);
        return null;
    }
}