public class SHAPE {
    private static final String CIRCLE = "Circle";
    private static final String TRIANGLE = "Triangle";
    private enum BaseShape {
        CIRCLE,
        TRIANGLE
    };
    private BaseShape baseShape;
    private SHAPE insideShaope;

    public void parse() {
        if (tokenizer.checkToken(CIRCLE)) {
            tokenizer.getAndCheckNext(CIRCLE);
            baseShape = CIRCLE;
        } else if (tokenizer.checkToken(TRIANGLE)) {
            tokenizer.getAndCheckNext(TRIANGLE);
            baseShape = TRIANGLE;
        }
        tokenizer.getAndCheckNext("With");
        while (tokenizer.moreTokens() && !tokenizer.checkToken("Inside")) {
            insideShape = new SHAPE();
            insideShape.parse();
        }
        tokenizer.getAndCheckNext("Inside");
    }
}

