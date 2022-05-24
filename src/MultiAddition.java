/**
 * This class represents a multiplication of a number of expressions
 */
public class MultiAddition extends MultiExpression {

    /**
     * constructor
     *
     * @param expressions unknown number of expressions being summed
     */
    public MultiAddition(Expression... expressions) {
        super(expressions);
    }

    /**
     * This function adds 2 doubles
     *
     * @param leftNumber  double
     * @param rightNumber double
     * @return result of addition
     */
    @Override
    public double add(double leftNumber, double rightNumber) {
        return leftNumber + rightNumber;
    }

    /**
     * @return String with symbol of addition
     */
    @Override
    public String getSymbol() {
        return " + ";
    }
}
