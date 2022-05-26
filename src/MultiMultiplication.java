/**
 * This class represents a multiplication of a number of expressions
 */
public class MultiMultiplication extends MultiExpression {

    /**
     * constructor
     *
     * @param expression1 an expression
     * @param expressions unknown number of expressions being multiplied
     */
    public MultiMultiplication(Expression expression1, Expression... expressions) {
        super(expression1, expressions);
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
