package ast;

import ui.Main;

public class PROCALLEXP extends EXP{
	String name;

	@Override
	public void parse() {
		tokenizer.getAndCheckNext("call");
		name = tokenizer.getNext();
		if (tokenizer.checkToken("\\(")) {
			tokenizer.getAndCheckNext("\\(");
			while (!tokenizer.checkToken("\\)")) {
				EXP arg = EXP.makeExp(tokenizer);
				arg.parse();
				while (tokenizer.checkToken(",")) {
					tokenizer.getAndCheckNext(",");
					EXP otherArg = EXP.makeExp(tokenizer);

					otherArg.parse();
				}
				break;
			}
			tokenizer.getAndCheckNext("\\)");
		}
	}

	@Override
	public Integer evaluate() {
		PROCBODY proBody = (PROCBODY) Main.symbolTable.get(name);
		return proBody.evaluate();
	}
    
}