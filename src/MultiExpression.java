/**
 * This class represents a multiplication of a number of expressions
 */
public abstract class MultiExpression extends Expression {

    private final Expression[] expressions;

    /**
     * constructor
     *
     * @param expressions unknown number of expressions
     */
    public MultiExpression(Expression... expressions) {
        this.expressions = expressions;
    }


    /**
     * This function evaluates the result of arithmetic operation on all expressions
     *
     * @return the result of all expressions
     */
    @Override
    public double evaluate() {
        double sum = expressions[0].evaluate();
        for (int i = 1; i < expressions.length; i++) {
            sum = add(sum, expressions[i].evaluate());
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
    public abstract double add(double leftNumber, double rightNumber);

    /**
     * This function gives a string representing expression
     *
     * @return a string representing expression
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("(");
        for (Expression expression : expressions) {
            s.append(expression.toString()).append(getSymbol());
        }
        s = new StringBuilder(s.substring(0, s.length() - 3));
        return s + ")";
    }

    /**
     * @return symbol of arithmetic operation being done
     */
    public abstract String getSymbol();
}
