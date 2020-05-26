package libs;

import java.io.PrintWriter;
import java.util.*;

public abstract class Node {
    protected Tokenizer tokenizer = Tokenizer.getTokenizer();

    abstract public void parse();
    abstract public Integer evaluate(Map<String, Object> symbolTable);
}
