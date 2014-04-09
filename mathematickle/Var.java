import org.dupontmanual.mtickle.Expression;

public class Var implements Expression {
    public Var() {
    }
    
    public String repr() {
        return "new Var()";
    }
    
    public String toString() {
        return "x";
    }
    
    public String toSmartString() {
        return this.toString();
    }
    
    public boolean containsVar() {
        return true;
    }
    
    public double eval(double x) {
        return x;
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
