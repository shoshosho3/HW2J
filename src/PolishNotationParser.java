public class PolishNotationParser extends ExpressionParser {

    @Override
    Expression parse(String expression) {
        expression = "1 " + expression;
        return parseByParts(expression.split(" "));
    }

    @Override
    void assignValues(Expression[] expressions, String[] parts) {
        expressions[0] = parseByParts(parts);
        expressions[1] = parseByParts(parts);
    }
}
