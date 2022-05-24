/**
 * This class represents a double
 */
public class DoubleLiteral extends Expression {

    private final double number;

    /**
     * constructor
     *
     * @param number double number
     */
    public DoubleLiteral(double number) {
        this.number = number;
    }

    /**
     * This function evaluates the value of double
     *
     * @return the value of double
     */
    @Override
    public double evaluate() {
        return number;
    }

    /**
     * This function gives a string representing expression
     *
     * @return a string representing expression
     */
    @Override
    public String toString() {
        return "(" + number + ")";
    }
}
