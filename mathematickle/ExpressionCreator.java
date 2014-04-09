import org.dupontmanual.mtickle.Expression;
import org.dupontmanual.mtickle.ExpressionFactory;
import org.dupontmanual.mtickle.Parser;

public class ExpressionCreator implements ExpressionFactory {
    public Expression makeNumber(double value) {
        return new Number(value);
    }
    
    public Expression makeVar() {
        return new Var();
    }
    
    public Expression makeNeg(Expression expr) {
        return new Neg(expr);
    }
    
    public Expression makeSin(Expression expr) {
        return null;
    }

    public Expression makeCos(Expression expr) {
        return null;
    }

    public Expression makeLn(Expression expr) {
        return null;
    }
    
    public Expression makeExponentiation(Expression base, Expression power) {
        return null;
    }

    public Expression makeProduct(Expression left, Expression right) {
        return null;
    }
    
    public Expression makeQuotient(Expression top, Expression bottom) {
        return null;
    }
    
    public Expression makeSum(Expression left, Expression right) {
        return new Sum(left, right);
    }
    
    public Expression makeDifference(Expression left, Expression right) {
        return null;
    }
}