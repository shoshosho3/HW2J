/**
 * This class represents subtraction of 2 expressions
 */
public class Subtraction extends MultiExpression {

    /**
     * constructor
     *
     * @param leftExpression  left expression in subtraction
     * @param rightExpression right expression in subtraction
     */
    public Subtraction(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    /**
     * This function subtracts 2 doubles
     *
     * @param leftNumber  double- subtrahend
     * @param rightNumber double- minuend
     * @return result of subtraction
     */
    @Override
    public double add(double leftNumber, double rightNumber) {
        return leftNumber - rightNumber;
    }

    /**
     * @return String with symbol of subtraction
     */
    @Override
    public String getSymbol() {
        return " - ";
    }
}
