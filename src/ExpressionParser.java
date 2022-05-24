abstract class ExpressionParser {

    abstract Expression parse(String expression);

    protected boolean isSymbol(char symbol) {
        return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/';
    }
}
