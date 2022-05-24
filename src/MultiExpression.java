/**
 * This class represents a multiplication of a number of expressions
 */
public abstract class MultiExpression extends Expression {

    protected final Expression[] expressions;

    /**
     * constructor
     *
     * @param expressions unknown number of expressions
     */
    public MultiExpression(Expression... expressions) {
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
            sum = add(sum, expression.evaluate());
        }
        return sum;
    }

    public abstract double add(double sum, double value);

    /**
     * This function gives a string representing expression
     *
     * @return a string representing expression
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("(");
        for( Expression expression : expressions) {
            s.append(expression.toString()).append(getSymbol());
        }
        s = new StringBuilder(s.substring(0, s.length() - 3));
        return s + ")";
    }

    public abstract String getSymbol();
}
