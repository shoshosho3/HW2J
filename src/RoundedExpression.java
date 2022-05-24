public class RoundedExpression extends Expression {

    private final Expression expression;
    private final int digits;

    /**
     * constructor
     *
     * @param expression expression being rounded
     * @param digits int of number of digits after dot
     */
    public RoundedExpression(Expression expression, int digits) {
        this.expression = expression;
        this.digits = digits;
    }

    /**
     * This function evaluates rounded value of expression with number of digits after dot
     *
     * @return rounded value of expression with number of digits after dot
     */
    @Override
    public double evaluate() {
        double num = 1;
        for (int i = 0; i < digits; i++) {
            num *= 10;
        }
        return (int) (expression.evaluate() * num) / num;
    }

    /**
     * This function gives a string representing expression
     *
     * @return a string representing expression
     */
    @Override
    public String toString() {
        return "(" + expression.toString() + ")";
    }
}
