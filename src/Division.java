/**
 * This class represents division of 2 expressions
 */
public class Division extends MultiExpression {

    /**
     * constructor
     *
     * @param leftExpression  left expression
     * @param rightExpression right expression
     */
    public Division(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public double add(double leftNumber, double rightNumber) {
        return leftNumber / rightNumber;
    }

    @Override
    public String getSymbol() {
        return " / ";
    }
}
