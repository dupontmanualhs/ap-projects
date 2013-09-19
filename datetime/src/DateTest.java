import static org.junit.Assert.*;

import org.junit.Test;

public class DateTest {
    Date d1 = new Date(1900, 1, 1);
    Date d2 = new Date(1904, 3, 17);
    Date d3 = new Date(2013,8,24);
    Date d4 = new Date(2000,2,12);
    Date d5 = new Date(1984,12,31);

    @Test
    public void testConstructorGivenDaysSince() {
        assertEquals(d1.toString(), new Date(d1.daysSince1900()).toString());
        assertEquals(d2.toString(), new Date(d2.daysSince1900()).toString());
        assertEquals(d3.toString(), new Date(d3.daysSince1900()).toString());
        assertEquals(d4.toString(), new Date(d4.daysSince1900()).toString());
        assertEquals(d5.toString(), new Date(d5.daysSince1900()).toString());
    }

    @Test
    public void testIsLeapYear() {
        assertFalse(d1.isLeapYear());
        assertTrue(d2.isLeapYear());
        assertFalse(d3.isLeapYear());
        assertTrue(d4.isLeapYear());
        assertTrue(d5.isLeapYear());
    }

    @Test
    public void testDaysInMonth() {
        assertEquals(31, d1.daysInMonth(1));
        assertEquals(28, d1.daysInMonth(2));
        assertEquals(29, d2.daysInMonth(2));
        assertEquals(31, d2.daysInMonth(3));
        assertEquals(30, d3.daysInMonth(4));
        assertEquals(30, d4.daysInMonth(11));
        assertEquals(31, d5.daysInMonth(7));
    }

    @Test
    public void testDaysInYearBeforeThisMonth() {
        assertEquals(0, d1.daysInYearBeforeThisMonth());
        assertEquals(60, d2.daysInYearBeforeThisMonth());
        assertEquals(31 + 28 + 31 + 30 + 31 + 30 + 31, d3.daysInYearBeforeThisMonth());
        assertEquals(31, d4.daysInYearBeforeThisMonth());
        assertEquals(335, d5.daysInYearBeforeThisMonth());
    }

    @Test
    public void testDayOfYear() {
        assertEquals(1, d1.dayOfYear());
        assertEquals(77, d2.dayOfYear());
        assertEquals(31 + 28 + 31 + 30 + 31 + 30 + 31 + 24, d3.dayOfYear());
        assertEquals(43, d4.dayOfYear());
        assertEquals(366, d5.dayOfYear());
    }

    @Test
    public void testToString() {
        assertEquals("January 1, 1900", d1.toString());
        assertEquals("March 17, 1904", d2.toString());
        assertEquals("August 24, 2013", d3.toString());
        assertEquals("February 12, 2000", d4.toString());
        assertEquals("December 31, 1984", d5.toString());
    }
}
