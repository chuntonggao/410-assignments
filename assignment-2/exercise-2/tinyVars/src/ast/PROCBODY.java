package ast;

import java.util.ArrayList;
import java.util.List;

public class PROCBODY extends EXP {
    private List<STATEMENT> statements = new ArrayList<>();
    private EXP returnVal;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("\\{");
        while (!tokenizer.checkToken("\\}") && !tokenizer.checkToken("return")) {
            STATEMENT s = null;
            if (tokenizer.checkToken("set")) {
                s = new SET();
            } else if (tokenizer.checkToken("new")) {
                s = new DEC();
            } else if (tokenizer.checkToken("print")) {
                s = new PRINT();
            } else if (tokenizer.checkToken("call")) {
                s = new PROCCALL();
            } else {
                throw new RuntimeException("Unknown statement:" + tokenizer.getNext());
            }
            s.parse();
            statements.add(s);
        }
        if (tokenizer.checkToken("return")) {
            tokenizer.getAndCheckNext("return");
            returnVal = EXP.makeExp(tokenizer);
            returnVal.parse();
        }
        tokenizer.getAndCheckNext("\\}");
    }

    @Override
    public Integer evaluate() {
        for (STATEMENT s : statements) {
            s.evaluate();
        }
        if (returnVal == null) {
            // void return type
            return null;
        }
        // non void return type
        Integer returnInteger = returnVal.evaluate();
        return returnInteger;
    }
}