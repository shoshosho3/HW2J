public class Addition extends Expression{

    private Expression left, right;

    public Addition(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }
}
