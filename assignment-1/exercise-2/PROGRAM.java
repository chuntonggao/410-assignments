package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;


public class PROGRAM extends Node {
    TITLE title;
    List<TABLE> tables = new ArrayList<>();
    String start = "<html>\n" +
            "<head>\n" +
            "<style>\n" +
            "td{font-size:44px;font-family:sans-serif}\n" +
            "h1{font-size:64px;font-family:sans-serif}\n" +
            "</style>\n" +
            "</head>\n" +
            "<body>\n";
    String end = "</body>\n" +
            "</html>\n";

    public void parse(){
        // Parse Title
        if (tokenizer.checkToken("Title:")) {
            tokenizer.getAndCheckNext("Title:");
            title = new TITLE();
            title.parse(); 
        } else {
            start = start + "<h1></h1>";
        }

        // Parse Tables
        while(tokenizer.moreTokens()){
            TABLE t = new TABLE();
            t.parse();
            tables.add(t);
        }
    }

    @Override
    public void evaluate() {
        writer.println(start);

        // Evaluate Title
        title.evaluate();

        // Evaluate Tables
        for (TABLE t : tables){
            t.evaluate();
        }

        writer.println(end);
    }
}
