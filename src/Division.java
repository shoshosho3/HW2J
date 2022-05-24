/**
 * This class represents division of 2 expressions
 */
public class Division extends Expression {

    private final Expression dividend, divisor;

    /**
     * constructor
     *
     * @param dividend expression being divided
     * @param divisor  expression being divided by
     */
    public Division(Expression dividend, Expression divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    /**
     * This function evaluates the quotient of the division
     *
     * @return the quotient of the division
     */
    @Override
    public double evaluate() {
        return dividend.evaluate() / divisor.evaluate();
    }

    /**
     * This function gives a string representing expression
     *
     * @return a string representing expression
     */
    @Override
    public String toString() {
        return "(" + dividend.toString() + " / " + divisor.toString() + ")";
    }
}
