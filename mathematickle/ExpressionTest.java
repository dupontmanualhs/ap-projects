import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.dupontmanual.mtickle.Parser;
import org.dupontmanual.mtickle.Expression;

public class ExpressionTest {
    private Parser p;
    private Expression num;
    private Expression var;
    private Expression neg;
    private Expression sin;
    private Expression cos;
    private Expression ln;
    private Expression sum;
    private Expression diff;
    private Expression prod;
    private Expression quot;
    private Expression exp;
    
    public ExpressionTest() {
        p = new Parser(new ExpressionCreator());
        num = p.parse("1");
        var = p.parse("x");
        neg = p.parse("~ x");
        sin = p.parse("sin 1");
        cos = p.parse("cos x");
        ln = p.parse("ln(~ 1)");
        sum = p.parse("x + 1");
        diff = p.parse("1 - x");
        prod = p.parse("x * x");
        quot = p.parse("1 / x");
        exp = p.parse("x ^ x");
    }
    
    
    @Test
    public void testRepr() {
        assertEquals("new Number(1.0)", num.repr());
        assertEquals("new Var()", var.repr());
        assertEquals("new Neg(new Var())", neg.repr());
        //assertEquals("new Sin(new Number(1.0))", sin.repr());
        //assertEquals("new Cos(new Var())", cos.repr());
        //assertEquals("new Ln(new Neg(new Number(1.0)))", ln.repr());
        assertEquals("new Sum(new Var(), new Number(1.0))", sum.repr());
        //assertEquals("new Diff(new Number(1.0), new Var())", diff.repr());
        //assertEquals("new Product(new Var(), new Var())", prod.repr());
        //assertEquals("new Quotient(new Number(1.0), new Var())", quot.repr());
        //assertEquals("new Exponentiation(new Var(), new Var())", exp.repr());
    }
}
