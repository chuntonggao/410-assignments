public class SHAPE {
    public void parse() {
        if (tokenizer.checkToken("Circle")) {
            tokenizer.getAndCheckNext("Circle");
        } else if (tokenizer.checkToken("Triangle")) {
            tokenizer.getAndCheckNext("Triangle");
        }
        tokenizer.getAndCheckNext("With");
        while (tokenizer.moreTokens() && !tokenizer.checkToken("Inside")) {
            SHAPE insideShape = new SHAPE();
            insideShape.parse();
        }
        tokenizer.getAndCheckNext("Inside");
    }
}

