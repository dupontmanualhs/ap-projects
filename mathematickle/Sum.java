import org.dupontmanual.mtickle.Expression;

public class Sum implements Expression {
    private Expression left;
    private Expression right;
    
    public Sum(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    
    public String repr() {
        return "new Sum(" + this.left.repr() + ", " + this.right.repr() + ")";
    }
    
    public String toString() {
        return "(" + this.left + " + " + this.right + ")";
    }
    
    private String leftSmartString() {
        if (this.left.getPrecedence() < this.getPrecedence()) {
            return "(" + this.left.toSmartString() + ")";
        } else {
            return this.left.toSmartString();
        }
    }
    
    private String rightSmartString() {
        if (this.right.getPrecedence() <= this.getPrecedence()) {
            return "(" + this.right.toSmartString() + ")";
        } else {
            return this.right.toSmartString();
        }
    }
    
    public String toSmartString() {
        return this.leftSmartString() + " + " + this.rightSmartString();
    }
    
    public boolean containsVar() {
        return this.left.containsVar() || this.right.containsVar();
    }
    
    public double eval(double x) {
        return this.left.eval(x) + this.right.eval(x);
    }
    
    public Expression simplify() {
        return this;
    }
    
    public Expression derivative() {
        return this;
    }
    
    public int getPrecedence() {
        return 0;
    }
}
