public class Subtraction extends MultiExpression {

    public Subtraction(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public double add(double leftNumber, double rightNumber) {
        return leftNumber - rightNumber;
    }

    @Override
    public String getSymbol() {
        return " - ";
    }
}
