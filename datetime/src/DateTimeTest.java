import static org.junit.Assert.*;

import org.junit.Test;

public class DateTimeTest {
	Date d1 = new Date(1970, 8, 13);
	Time t1 = new Time(23, 43, 0);
    DateTime dt1 = new DateTime(d1, t1);
    Date d2 = new Date(1900, 1, 1);
    Time t2 = new Time(0, 0, 0);
    DateTime dt2 = new DateTime(d2, t2);
    Date d3 = new Date(1969, 7, 16);
    Time t3 = new Time(13, 32, 0);
    DateTime dt3 = new DateTime(d3, t3);
    Date d4 = new Date(1912, 4, 14);
    Time t4 = new Time(23, 40, 00);
    DateTime dt4 = new DateTime(d4, t4);
    
    @Test
    public void testToString() {
    	assertEquals("11:43:00 PM August 13, 1970", dt1.toString());
    	assertEquals("12:00:00 AM January 1, 1900", dt2.toString());
    	assertEquals("1:32:00 PM July 16, 1969", dt3.toString());
    	assertEquals("11:40:00 PM April 14, 1912", dt4.toString());
    }
    
    @Test
    public void testConstructorSecondsSince1900() {
    	assertEquals(new DateTime(dt1.secondsSince1900()).toString(),
    			dt1.toString());
    	assertEquals(new DateTime(dt2.secondsSince1900()).toString(),
    			dt2.toString());
    	assertEquals(new DateTime(dt3.secondsSince1900()).toString(),
    			dt3.toString());
    	assertEquals(new DateTime(dt4.secondsSince1900()).toString(),
    			dt4.toString());
    }
    
    @Test
    public void testSecondsSince1900() {
    	assertEquals(d1.daysSince1900() * (24L * 60 * 60) + t1.secondsSinceMidnight(),
    			dt1.secondsSince1900());
    	assertEquals(d2.daysSince1900() * (24L * 60 * 60) + t2.secondsSinceMidnight(),
    			dt2.secondsSince1900());
    	assertEquals(d3.daysSince1900() * (24L * 60 * 60) + t3.secondsSinceMidnight(),
    			dt3.secondsSince1900());
    	assertEquals(d4.daysSince1900() * (24L * 60 * 60) + t4.secondsSinceMidnight(),
    			dt4.secondsSince1900());
    	
    }
}
