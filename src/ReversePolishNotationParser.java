public class ReversePolishNotationParser extends ExpressionParser {
    @Override
    int direction() {return -1;}

    @Override
    int beginIndex(String expression) {return 0;}

    @Override
    int endIndex(String expression) {return expression.length() - 1;}

    @Override
    int getEndIndex(String expression) {
        return expression.lastIndexOf(" ");
    }
}
