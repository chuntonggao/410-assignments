package ast;

import java.util.*;

public class PROCBODY extends EXP {
    private List<STATEMENT> statements = new ArrayList<>();
    private EXP returnVal;
    private List<NAME> args = new ArrayList<>();
    private List<Integer> argResults = new ArrayList<>();
    private Map<String, Object> localSymbolTable = new HashMap<String, Object>();

    public void setArgResults(List<Integer> argResults) {
        this.argResults = argResults;
    }

    @Override
    public void parse() {
        if (tokenizer.checkToken("\\(")) {
            tokenizer.getAndCheckNext("\\(");
            while (!tokenizer.checkToken("\\)")) {
                NAME arg = (NAME) EXP.makeExp(tokenizer);
                if (!(arg instanceof NAME)) {
                    throw new RuntimeException("Expect NAME, but get: " + arg.toString());
                }
                arg.parse();
                args.add(arg);
                while (tokenizer.checkToken(",")) {
                    tokenizer.getAndCheckNext(",");
                    NAME otherArg = (NAME) EXP.makeExp(tokenizer);
                    if (!(otherArg instanceof NAME)) {
                        throw new RuntimeException("Expect NAME, but get: " + arg.toString());
                    }
                    otherArg.parse();
                    args.add(otherArg);
                }
                break;
            }
            tokenizer.getAndCheckNext("\\)");
        }
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
    public Integer evaluate(Map<String, Object> symbolTable) {
        for (int i = 0; i < args.size(); i++) {
            NAME arg = args.get(i);
            Integer argResult = argResults.get(i);
            String argName = arg.toString();
            localSymbolTable.put(argName, argResult);
        }
        for (STATEMENT s : statements) {
            s.evaluate(localSymbolTable);
        }
        if (returnVal == null) {
            // void return type
            return null;
        }
        // non void return type
        Integer returnInteger = returnVal.evaluate(localSymbolTable);
        return returnInteger;
    }
}