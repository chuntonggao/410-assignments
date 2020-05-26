package ast;

import ui.Main;

public class PROCCALL extends STATEMENT{
	String name;

	@Override
	public void parse() {
		tokenizer.getAndCheckNext("call");
		name = tokenizer.getNext();
	}

	@Override
	public Integer evaluate() {
		PROCBODY proBody = (PROCBODY) Main.symbolTable.get(name);
		proBody.evaluate();
		return null;
	}
    
}