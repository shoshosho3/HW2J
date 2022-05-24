public class RoundedExpression extends Expression {

    private Expression expression;
    private int digits;

    public RoundedExpression(Expression expression, int digits) {
        this.expression = expression;
        this.digits = digits;
    }

    @Override
    public double evaluate() {
        double num = 1;
        for (int i = 0; i < digits; i++) {
            num *= 10;
        }
        return (int) (expression.evaluate() * num) / num;
    }

    @Override
    public String toString() {
        return expression.toString();
    }
}
