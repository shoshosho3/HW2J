public class PolishNotationParser extends ExpressionParser {

    @Override
    Expression parse(String expression) {
        Expression[] expressions = new Expression[expression.length()];
        boolean[] expressionEnds = new boolean[expression.length()];

        if (!isSymbol(expression.charAt(0))) return intOrDouble(expression);

        for (int i = expression.length() - 1; i >= 0; i--) {
            if (isSymbol(expression.charAt(i))) buildExpression(expression, i, expressions, expressionEnds);
        }

        return expressions[0];
    }

    void buildExpression(String expression, int index, Expression[] expressions, boolean[] expressionEnds) {
        if (expression.charAt(index + 1) == 'u') {
            expressions[index] =
                    new UnaryMinus(getExpression(expression, index + 3, expressions, expressionEnds, false));
        } else {
            int afterSpace = index + 2;
            int middle = getMiddle(expression.substring(afterSpace), afterSpace, expressions, expressionEnds);
            Expression rightExpression, leftExpression;
            leftExpression = getExpression(expression, afterSpace, expressions, expressionEnds, false);
            rightExpression = getExpression(expression, middle, expressions, expressionEnds, true);
            if (expression.charAt(index) == '+')
                expressions[index] = new Addition(leftExpression, rightExpression);
            if (expression.charAt(index) == '-')
                expressions[index] = new Subtraction(leftExpression, rightExpression);
            if (expression.charAt(index) == '*')
                expressions[index] = new Multiplication(leftExpression, rightExpression);
            if (expression.charAt(index) == '/')
                expressions[index] = new Division(leftExpression, rightExpression);
        }
    }

    int getMiddle(String expression, int index, Expression[] expressions, boolean[] expressionEnds) {
        if (expressions[index] != null) {
            for (int i = index; i < expressionEnds.length; i++) {
                if (expressionEnds[i]) {
                    expressionEnds[i] = false;
                    return i + 2;
                }
            }
        }
        return expression.indexOf(" ") + index + 1;
    }

    Expression getExpression(String expression, int index, Expression[] expressions,
                             boolean[] expressionEnds, boolean endOfExpression) {
        if (expressions[index] != null)
            return expressions[index];

        int nextSpace = expression.substring(index).indexOf(" ") + index;
        int end = (nextSpace == index - 1) ? expression.length() : nextSpace;
        if (endOfExpression) expressionEnds[end - 1] = true;
        return intOrDouble(expression.substring(index, end));
    }


    Expression intOrDouble(String str) {
        if (str.contains(".")) return new DoubleLiteral(Double.parseDouble(str));
        return new IntegerLiteral(Integer.parseInt(str));
    }
}
