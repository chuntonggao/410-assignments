package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class PROGRAM extends Node {
    private List<Node> nodes = new ArrayList<>();

    @Override
    public void parse() {
        while (tokenizer.moreTokens()) {
            if (tokenizer.checkToken("def")) {
                PROCDEF procDef = new PROCDEF();
                procDef.parse();
                nodes.add(procDef);
            } else if (tokenizer.checkToken("set") || tokenizer.checkToken("new") || tokenizer.checkToken("print")
                    || tokenizer.checkToken("call")) {
                STATEMENT s = null;
                if (tokenizer.checkToken("set")) {
                    s = new SET();
                } else if (tokenizer.checkToken("new")) {
                    s = new DEC();
                } else if (tokenizer.checkToken("print")) {
                    s = new PRINT();
                } else if (tokenizer.checkToken("call")) {
                    s = new PROCCALL();
                }
                s.parse();
                nodes.add(s);
            } else {
                throw new RuntimeException(
                        "Unknown input:" + tokenizer.getNext() + " expect procedure definition or statement");
            }
        }

    }

    @Override
    public Integer evaluate() {
        for (Node node : nodes) {
            node.evaluate();
        }
        return null; // we only return a value for expressions (EXP); evaluation of
                     // programs/statements is via side-effects
    }
}
