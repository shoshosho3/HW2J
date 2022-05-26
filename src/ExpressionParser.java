/**
 * This class represents a parser of an expression
 */
abstract class ExpressionParser {

    /**
     * This function gets a string representing an expression and returns the fitting Expression
     *
     * @param expression string representing an expression
     * @return fitting Expression to string
     */
    abstract Expression parse(String expression);

    /**
     * This function gets an array of strings representing an expression and parses it to an expression
     *
     * @param parts array of strings which are parts of an expression
     * @return an Expression of the string parts
     */
    protected Expression parseByParts(String[] parts) {

        int index = Integer.parseInt(parts[0]);
        String curr = parts[index];
        parts[0] = "" + (index + 1);

        //checking if current part is unary minus
        if (curr.equals("-u")) {
            Expression exp = parseByParts(parts);
            return new UnaryMinus(exp);
        }
        //checking if current part is a symbol
        if (isSymbol(curr.charAt(0))) {
            return dualExpression(parts, curr);
        }
        return literalExpression(curr);
    }

    /**
     * This function gets a symbol and String parts of expressions
     * and returns the arithmetic function of symbol on expressions
     *
     * @param parts  String array of parts of an expression
     * @param symbol String representing an arithmetic symbol
     * @return the arithmetic function of symbol on expressions
     */
    private Expression dualExpression(String[] parts, String symbol) {

        Expression[] expressions = new Expression[2];
        assignValues(expressions, parts);
        switch (symbol) {
            case "-":
                return new Subtraction(expressions[0], expressions[1]);
            case "+":
                return new Addition(expressions[0], expressions[1]);
            case "*":
                return new Multiplication(expressions[0], expressions[1]);
            default:
                return new Division(expressions[0], expressions[1]);
        }

    }

    /**
     * This function assigns values to expression in right order
     *
     * @param expressions array of 2 expressions
     * @param parts       String array of parts of an expression
     */
    abstract void assignValues(Expression[] expressions, String[] parts);

    /**
     * This function gets a string representing a literal double or literal integer and returns an
     * Expression representing it
     *
     * @param str string representing a literal double
     * @return an expression representing str
     */
    private Expression literalExpression(String str) {
        if (str.contains(".")) return new DoubleLiteral(Double.parseDouble(str));
        return new IntegerLiteral(Integer.parseInt(str));
    }

    /**
     * This function gets a char and decides if it's a symbol
     * @param symbol a char
     * @return true is symbol is a symbol, otherwise false
     */
    protected boolean isSymbol(char symbol) {
        return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/';
    }
}
