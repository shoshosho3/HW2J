abstract class ExpressionParser {

    Expression parse(String expression) {
        Expression[] expressions = new Expression[expression.length()];
        boolean[] expressionEnds = new boolean[expression.length()];

        if (!(isSymbol(expression.charAt(endIndex(expression))) || expression.charAt(endIndex(expression)) == 'u')) return intOrDouble(expression);

        for (int i = beginIndex(expression); i != endIndex(expression) - direction(); i -= direction()) {
            if (isSymbol(expression.charAt(i))) {
                buildExpression(expression, i, expressions, expressionEnds);
            }
        }

        return expressions[endIndex(expression)];
    }

    abstract int beginIndex(String expression);
    abstract int endIndex(String expression);
    abstract int direction();

    void buildExpression(String expression, int index, Expression[] expressions, boolean[] expressionEnds) {
        if (index + 1 < expression.length() && expression.charAt(index + 1) == 'u') {
            int i = index + 2 * direction() +((direction() + 1)/2);
            while (i > 0 && (expression.charAt(i - 1) != ' ')) i--;
            expressions[index] =
                    new UnaryMinus(getExpression(expression, i, index + 2 * direction() +((direction() + 1)/2), expressions, expressionEnds, true));
            expressions[index + 1] = expressions[index];
        } else {
            int afterSpace = index + 2 * direction();

            String str = expression.substring(min(beginIndex(expression), afterSpace), max(beginIndex(expression), afterSpace) + 1);
            int middle = getMiddle(str, afterSpace, expressions, expressionEnds);
            int rightIndex = max(middle, afterSpace);
            while(rightIndex > 0 && expression.charAt(rightIndex - 1) != ' ') rightIndex--;
            int leftIndex = min(middle, afterSpace);
            while(leftIndex > 0 && expression.charAt(leftIndex - 1) != ' ') leftIndex--;
            Expression rightExpression, leftExpression;
            int leftRight = (direction() == 1) ? middle - 2 : middle;
            leftExpression = getExpression(expression, leftIndex, leftRight, expressions, expressionEnds, direction() == -1);
            rightExpression = getExpression(expression, rightIndex,max(middle, afterSpace), expressions, expressionEnds, direction() == 1);
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

    int min(int num1, int num2) {
        return (num1 < num2) ? num1 : num2;
    }

    int max(int num1, int num2) {
        return (num1 > num2) ? num1 : num2;
    }

    int getMiddle(String expression, int index, Expression[] expressions, boolean[] expressionEnds) {
        if (expressions[index] != null) {
            for (int i = index; i != beginIndex(expression) + direction(); i += direction()) {
                if (expressionEnds[i]) {
                    expressionEnds[i] = false;
                    return i + 2 * direction();
                }
            }
        }
        return getEndIndex(expression) + ((direction() + 1)/2) + index + ((direction() - 1)/2) * expression.length();
    }

    abstract int getEndIndex(String expression);

    Expression getExpression(String expression, int index, int rightEnd, Expression[] expressions,
                             boolean[] expressionEnds, boolean endOfExpression) {
        if (expressions[index] != null)
            return expressions[index];

        if (endOfExpression) expressionEnds[(direction() == 1) ? rightEnd : index] = true;
        return intOrDouble(expression.substring(index, rightEnd+1));
    }


    Expression intOrDouble(String str) {
        if (str.contains(".")) return new DoubleLiteral(Double.parseDouble(str));
        return new IntegerLiteral(Integer.parseInt(str));
    }

    protected boolean isSymbol(char symbol) {
        return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/';
    }
}
