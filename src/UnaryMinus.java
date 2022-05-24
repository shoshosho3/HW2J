public class UnaryMinus extends Expression {

    Expression expression;

    public UnaryMinus(Expression expression) {
        this.expression = expression;
    }

    @Override
    public double evaluate() {
        return -1 * expression.evaluate();
    }

    @Override
    public String toString() {
        return "(-" + expression.toString() + ")";
    }
}
