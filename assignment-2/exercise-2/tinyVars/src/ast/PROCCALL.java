package ast;

import java.util.*;

public class PROCCALL extends STATEMENT {
	String name;
	List<EXP> args = new ArrayList<>();
	List<Integer> argResults = new ArrayList<>();

	@Override
	public void parse() {
		tokenizer.getAndCheckNext("call");
		name = tokenizer.getNext();
		if (tokenizer.checkToken("\\(")) {
			tokenizer.getAndCheckNext("\\(");
			while (!tokenizer.checkToken("\\)")) {
				EXP arg = EXP.makeExp(tokenizer);
				arg.parse();
				args.add(arg);
				while (tokenizer.checkToken(",")) {
					tokenizer.getAndCheckNext(",");
					EXP otherArg = EXP.makeExp(tokenizer);
					otherArg.parse();
					args.add(otherArg);
				}
				break;
			}
			tokenizer.getAndCheckNext("\\)");
		}
	}

	@Override
	public Integer evaluate(Map<String, Object> symbolTable) {
		for (EXP arg: args) {
			Integer argResult = arg.evaluate(symbolTable);
			argResults.add(argResult);
		}
		PROCBODY proBody = (PROCBODY) symbolTable.get(name);
		proBody.setArgResults(argResults);
		proBody.evaluate(symbolTable);
		return null;
	}
}