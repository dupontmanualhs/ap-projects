import static org.junit.Assert.*;

import org.junit.Test;

public class TimeTest {
    Time t1 = new Time(0, 0, 0);
    Time t2 = new Time(6, 1, 2);
    Time t3 = new Time(11, 59, 59);
    Time t4 = new Time(12, 0, 0);
    Time t5 = new Time(15, 15, 15);
    Time t6 = new Time(20, 2, 30);
    Time t7 = new Time(21, 30, 5);
    Time t8 = new Time(23, 59, 59);
    
    @Test
    public void testToString() {
        assertEquals("12:00:00 AM", t1.toString());
        assertEquals("6:01:02 AM", t2.toString());
        assertEquals("11:59:59 AM", t3.toString());
        assertEquals("12:00:00 PM", t4.toString());
        assertEquals("3:15:15 PM", t5.toString());
        assertEquals("8:02:30 PM", t6.toString());
        assertEquals("9:30:05 PM", t7.toString());
        assertEquals("11:59:59 PM", t8.toString());        
    }
    
    @Test
    public void testSecondsSinceMidnight() {
        assertEquals(new Time(t1.secondsSinceMidnight()).toString(), t1.toString());
        assertEquals(new Time(t2.secondsSinceMidnight()).toString(), t2.toString());
        assertEquals(new Time(t3.secondsSinceMidnight()).toString(), t3.toString());
        assertEquals(new Time(t4.secondsSinceMidnight()).toString(), t4.toString());
        assertEquals(new Time(t5.secondsSinceMidnight()).toString(), t5.toString());
        assertEquals(new Time(t6.secondsSinceMidnight()).toString(), t6.toString());
        assertEquals(new Time(t7.secondsSinceMidnight()).toString(), t7.toString());
        assertEquals(new Time(t8.secondsSinceMidnight()).toString(), t8.toString());
    }
}    
