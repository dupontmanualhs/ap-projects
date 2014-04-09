import org.dupontmanual.mtickle.Expression;

public class Neg implements Expression {
    private Expression value;
    
    public Neg(Expression value) {
        this.value = value;
    }
    
    public String repr() {
        return "new Neg(" + this.value.repr() + ")";
    }
    
    public String toString() {
        return "~(" + value + ")";
    }
    
    public String toSmartString() {
        if (this.getPrecedence() < this.value.getPrecedence()) {
            return "~ " + this.value.toSmartString();
        } else {
            return "~(" + this.value.toSmartString() + ")";
        }
    }
    
    public boolean containsVar() {
        return this.value.containsVar();
    }
    
    public double eval(double x) {
        return -1 * this.value.eval(x);
    }
    
    public Expression simplify() {
        return this;
    }
    
    public Expression derivative() {
        return this;
    }
    
    public int getPrecedence() {
        return 3;
    }
}
