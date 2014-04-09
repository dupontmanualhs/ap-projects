import org.dupontmanual.mtickle.Expression;

public class Number implements Expression {
    private double value;
    
    public Number(double value) {
        this.value = value;
    }
    
    public String repr() {
        return "new Number(" + this.value + ")";
    }
    
    public String toString() {
        return "" + value;
    }
    
    public String toSmartString() {
        if (((int) this.value) == this.value) {
            return "" + ((int) this.value);
        } else {
            return this.toString();
        }
    }
    
    public boolean containsVar() {
        return false;
    }
    
    public double eval(double x) {
        return this.value;
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
