abstract class ExpressionParser {

    private Expression parseByParts(String[] parts) {

        int index = Integer.parseInt(parts[0]);
        String curr = parts[index];
        parts[0] = "" + (index + 1);

        if (curr.equals("-u")) {
            Expression exp = parseByParts(parts);
            return new UnaryMinus(exp);
        }
        if (isSymbol(curr.charAt(0))) {
            return dualExpression(parts, curr);
        }
        return literalExpression(curr);
    }


    Expression parse(String expression) {

        if (direction() == -1) {
            expression = reverse(expression);
            expression = "1 " + expression;
            String[] parts = expression.split(" ");
            for (int i = 0; i < parts.length; i++) {
                if (parts[i] != "-u") {
                    parts[i] = reverse(parts[i]);
                }
            }
            return parseByParts(parts);
        }
        expression = "1 " + expression;
        return parseByParts(expression.split(" "));
    }


    private String reverse(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result = s.charAt(i) + result;
        }
        return result;
    }


    abstract int beginIndex(String expression);

    abstract int endIndex(String expression);

    abstract int direction();


    abstract int getEndIndex(String expression);

    private Expression dualExpression(String[] parts, String symbol) {

        Expression left, right;
        switch (symbol) {
            case "-":
                left = parseByParts(parts);
                right = parseByParts(parts);
                if (direction() == -1) return new Subtraction(right, left);
                return new Subtraction(left, right);

            case "+":
                left = parseByParts(parts);
                right = parseByParts(parts);
                if (direction() == -1) return new Addition(right, left);
                return new Addition(left, right);

            case "*":
                left = parseByParts(parts);
                right = parseByParts(parts);

                if (direction() == -1) return new Multiplication(right, left);
                return new Multiplication(left, right);

            default:
                left = parseByParts(parts);
                right = parseByParts(parts);

                if (direction() == -1) return new Division(right, left);
                return new Division(left, right);

        }

    }

    private Expression literalExpression(String str) {
        if (str.contains(".")) return new DoubleLiteral(Double.parseDouble(str));
        return new IntegerLiteral(Integer.parseInt(str));
    }

    protected boolean isSymbol(char symbol) {
        return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/';
    }

}

