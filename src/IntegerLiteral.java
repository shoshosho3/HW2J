/**
 * This class represents an integer
 */
public class IntegerLiteral extends Expression {

    private final int number;

    /**
     * constructor
     *
     * @param number int being represented
     */
    public IntegerLiteral(int number) {
        this.number = number;
    }

    /**
     * This function evaluates the value of integer
     *
     * @return the value of integer
     */
    @Override
    public double evaluate() {
        return number;
    }

}
