public class Addition extends Expression{

    private int number1, number2;
    @Override
    public double evaluate() {
        return number1 + number2;
    }

    @Override
    public String toString() {
        return "(" + number1 + ")" + "+ (" + number2 + ")";
    }
}
