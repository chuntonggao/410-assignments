package ast;

import ui.Main;
import java.util.ArrayList;
import java.util.List;

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
	public Integer evaluate() {
		for (EXP arg: args) {
			Integer argResult = arg.evaluate();
			argResults.add(argResult);
		}
		PROCBODY proBody = (PROCBODY) Main.symbolTable.get(name);
		proBody.setArgResults(argResults);
		proBody.evaluate();
		return null;
	}

}