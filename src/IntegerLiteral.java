public class IntegerLiteral extends Expression {

    private int number;

    public IntegerLiteral(int number) {
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
