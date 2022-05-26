/**
 * This class represents a parser of polish notation
 */
public class PolishNotationParser extends ExpressionParser {

    @Override
    public Expression parse(String expression) {
        expression = "1 " + expression;
        return parseByParts(expression.split(" "));
    }

    @Override
    protected void assignValues(Expression[] expressions, String[] parts) {
        expressions[0] = parseByParts(parts);
        expressions[1] = parseByParts(parts);
    }
}
