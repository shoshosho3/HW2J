/**
 * This class represents a multiplication of a number of expressions
 */
public class MultiAddition extends Expression {

    private final Expression[] expressions;

    /**
     * constructor
     *
     * @param expressions unknown number of expressions
     */
    public MultiAddition(Expression... expressions) {
        this.expressions = expressions;
    }


    /**
     * This function evaluates the sum of all expressions
     *
     * @return the sum of all expressions
     */
    @Override
    public double evaluate() {
        double sum = 0;
        for( Expression expression : expressions) {
            sum += expression.evaluate();
        }
        return sum;
    }

    /**
     * This function gives a string representing expression
     *
     * @return a string representing expression
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("(");
        for( Expression expression : expressions) {
            s.append(expression.toString()).append(" + ");
        }
        s = new StringBuilder(s.substring(0, s.length() - 3));
        return s + ")";
    }
}
