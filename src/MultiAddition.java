/**
 * This class represents a multiplication of a number of expressions
 */
public class MultiAddition extends MultiExpression {

    public MultiAddition(Expression... expressions) {
        super(expressions);
    }

    @Override
    public double add(double sum, double value) {
        return sum + value;
    }

    @Override
    public String getSymbol() {
        return " + ";
    }
}
