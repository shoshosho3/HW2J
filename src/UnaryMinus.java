/**
 * This class represents a unary minus of expression
 */
public class UnaryMinus extends Expression {

    private final Expression expression;

    /**
     * constructor
     *
     * @param expression expression
     */
    public UnaryMinus(Expression expression) {
        this.expression = expression;
    }

    /**
     * This function evaluates the additive inverse of expression
     *
     * @return the additive inverse of expression
     */
    @Override
    public double evaluate() {
        return -1 * expression.evaluate();
    }

    /**
     * This function gives a string representing expression
     *
     * @return a string representing expression
     */
    @Override
    public String toString() {
        return "(-" + expression.toString() + ")";
    }
}
