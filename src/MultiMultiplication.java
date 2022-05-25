/**
 * This class represents a multiplication of a number of expressions
 */
public class MultiMultiplication extends MultiExpression {

    /**
     * constructor
     *
     * @param expressions unknown number of expressions being multiplied
     */
    public MultiMultiplication(Expression... expressions) {
        super(expressions);
    }

    /**
     * This function multiplies 2 doubles
     *
     * @param leftNumber  double
     * @param rightNumber double
     * @return result of multiplication
     */
    @Override
    public double add(double leftNumber, double rightNumber) {
        return leftNumber * rightNumber;
    }



    /**
     * @return String with symbol of multiplication
     */
    @Override
    public String getSymbol() {
        return " * ";
    }
}
