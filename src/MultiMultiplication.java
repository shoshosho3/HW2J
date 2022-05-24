/**
 * This class represents a multiplication of a number of expressions
 */
public class MultiMultiplication extends MultiExpression {

    public MultiMultiplication(Expression... expressions) {
        super(expressions);
    }

    @Override
    public double add(double sum, double value) {
        return sum * value;
    }

    @Override
    public String getSymbol() {
        return " * ";
    }
}
