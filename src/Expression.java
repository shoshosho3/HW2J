/**
 * This class represents an arithmetic expression
 */
public abstract class Expression {

    /**
     * This function evaluates value of expression
     *
     * @return value of expression
     */
    abstract public double evaluate() ;

    /**
     * This function gives a string representing expression
     *
     * @return a string representing expression
     */
    @Override
    public String toString() {
        return "(" + evaluate() + ")";
    }
}
