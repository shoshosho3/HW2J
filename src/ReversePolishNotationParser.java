/**
 * This class represents a parser of reverse polish notation
 */
public class ReversePolishNotationParser extends ExpressionParser {

    @Override
    Expression parse(String expression) {
        expression = reverse(expression);
        expression = "1 " + expression;
        String[] parts = expression.split(" ");
        for (int i = 0; i < parts.length; i++) {
            if (!(parts[i].equals("-u"))) {
                parts[i] = reverse(parts[i]);
            }
        }
        return parseByParts(parts);
    }

    /**
     * This function gets a string and reverses it
     *
     * @param str a string
     * @return reversed str
     */
    private String reverse(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            result.insert(0, str.charAt(i));
        }
        return result.toString();
    }

    @Override
    void assignValues(Expression[] expressions, String[] parts) {
        expressions[1] = parseByParts(parts);
        expressions[0] = parseByParts(parts);
    }
}
