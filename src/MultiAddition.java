public class MultiAddition extends Expression {

    private Expression expressions[];

    public MultiAddition(Expression... expressions) {
        this.expressions = expressions;
    }

    @Override
    public double evaluate() {
        double sum = 0;
        for( Expression expression : expressions) {
            sum += expression.evaluate();
        }
        return sum;
    }

    @Override
    public String toString() {
        String s = "(";
        for( Expression expression : expressions) {
            s += expression.toString() + " + ";
        }
        s = s.substring(0,s.length() - 3);
        return s + ")";
    }
}
