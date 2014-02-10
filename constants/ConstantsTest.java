import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstantsTest {
    private static final double SERIES_ACCURACY = 0.0000000001;
    private static final double RANDOM_ACCURACY = 0.1;

    @Test
    public void gcd1() {
        assertEquals(5, Constants.gcd(735, 145));
    }
   
    @Test
    public void factorial1() {
        assertEquals(120L, Constants.factorial(5));
    }
    
    @Test
    public void piSeries1() {
        assertEquals(4.0, Constants.piSeries(1), SERIES_ACCURACY);
    }
   
    @Test
    public void piRandom1() {
        assertEquals(Math.PI, Constants.piRandom(1000), RANDOM_ACCURACY);
    }
   
    @Test
    public void eSeries1() {
        assertEquals(2.0, Constants.eSeries(1), SERIES_ACCURACY);
    }
   
    @Test
    public void eRandom1() {
        assertEquals(Math.E, Constants.eRandom(1000), RANDOM_ACCURACY);
    }
}