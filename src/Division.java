/**
 * This class represents division of 2 expressions
 */
public class Division extends MultiExpression {

    /**
     * constructor
     *
     * @param leftExpression  left expression in division
     * @param rightExpression right expression in division
     */
    public Division(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    /**
     * This function divides 2 doubles
     *
     * @param leftNumber  double- dividend
     * @param rightNumber double- divisor
     * @return result of division
     */
    @Override
    public double add(double leftNumber, double rightNumber) {
        return leftNumber / rightNumber;
    }



    /**
     * @return String with symbol of division
     */
    @Override
    public String getSymbol() {
        return " / ";
    }
}
