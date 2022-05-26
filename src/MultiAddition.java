/**
 * This class represents a multiplication of a number of expressions
 */
public class MultiAddition extends MultiExpression {

    /**
     * constructor
     *
     * @param expression1 an expression
     * @param expressions unknown number of expressions being summed
     */
    public MultiAddition(Expression expression1, Expression... expressions) {
        super(expression1, expressions);
    }

    /**
     * This function adds 2 doubles
     *
     * @param leftNumber  double
     * @param rightNumber double
     * @return result of addition
     */
    @Override
    protected double add(double leftNumber, double rightNumber) {
        return leftNumber + rightNumber;
    }



    /**
     * @return String with symbol of addition
     */
    @Override
    protected String getSymbol() {
        return " + ";
    }
}
