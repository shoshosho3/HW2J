public class MultiMultiplication extends Expression {

    Expression[] expressions;

    public MultiMultiplication(Expression... expressions) {
        this.expressions = expressions;
    }

    @Override
    public double evaluate() {
        int result = 1;
        for (Expression exp : expressions) {
            result *= exp.evaluate();
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "(";

        for (Expression exp : expressions) {
            result += exp.toString() + " * ";
        }
        result = result.substring(0, result.length() - 3);
        return result + ")";
    }
}
