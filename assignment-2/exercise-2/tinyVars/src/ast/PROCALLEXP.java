package ast;

import ui.Main;

public class PROCALLEXP extends EXP{
	String name;

	@Override
	public void parse() {
		tokenizer.getAndCheckNext("call");
		name = tokenizer.getNext();
	}

	@Override
	public Integer evaluate() {
		PROCBODY proBody = (PROCBODY) Main.symbolTable.get(name);
		return proBody.evaluate();
	}
    
}