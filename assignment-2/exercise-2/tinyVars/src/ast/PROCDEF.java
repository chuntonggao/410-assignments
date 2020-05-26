package ast;

import libs.Node;
import ui.Main;

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
    public Integer evaluate() {
        System.out.println("Define procedure " + this.name + " and put into symbol table");
        Main.symbolTable.put(name, procBody);
        return null;
    }
}