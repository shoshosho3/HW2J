/**
 * This class represents a multiplication of a number of expressions
 */
public abstract class MultiExpression extends Expression {

    private final Expression expression1;
    private final Expression[] expressions;

    /**
     * constructor
     *
     * @param expression1 an expression
     * @param expressions unknown number of expressions
     */
    public MultiExpression(Expression expression1, Expression... expressions) {
        this.expression1 = expression1;
        this.expressions = expressions;
    }


    /**
     * This function evaluates the result of arithmetic operation on all expressions
     *
     * @return the result of all expressions
     */
    @Override
    public double evaluate() {
        double sum = expression1.evaluate();
        for(Expression expression : expressions) {
            sum = add(sum, expression.evaluate());
        }
        return sum;
    }

    /**
     * This function activates arithmetic operation on 2 doubles
     *
     * @param leftNumber  double
     * @param rightNumber double
     * @return result of arithmetic operation
     */
    protected abstract double add(double leftNumber, double rightNumber);

    /**
     * This function gives a string representing expression
     *
     * @return a string representing expression
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("(" + expression1 + getSymbol());
        for (Expression expression : expressions) {
            s.append(expression.toString()).append(getSymbol());
        }
        s = new StringBuilder(s.substring(0, s.length() - 3));
        return s + ")";
    }

    /**
     * @return symbol of arithmetic operation being done
     */
    protected abstract String getSymbol();
}
