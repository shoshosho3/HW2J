public class DoubleLiteral extends Expression {

    private double number;

    public DoubleLiteral(double number) {
        this.number = number;
    }

    @Override
    public double evaluate() {
        return number;
    }

    @Override
    public String toString() {
        return "(" + number + ")";
    }
}
