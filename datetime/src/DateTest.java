import static org.junit.Assert.*;

import org.junit.Test;


public class DateTest {
	Date d1 = new Date(1900, 1, 1);


	@Test
	public void testYearGivenDaysSince() {
		assertEquals(d1.toString(), new Date(d1.daysSince1900()).toString());
	}

	@Test
	public void testIsLeapYear() {
		assertFalse(d1.isLeapYear());
	}

	@Test
	public void testDaysInMonth() {
		assertEquals(31, d1.daysInMonth(1));
	}

	@Test
	public void testDaysInYearBeforeThisMonth() {
		assertEquals(0, d1.daysInYearBeforeThisMonth());
	}

	@Test
	public void testDayOfYear() {
		assertEquals(1, d1.dayOfYear());
	}

	@Test
	public void testDaysSince1900() {
		assertEquals(1, d1.daysSince1900());
	}

	@Test
	public void testToString() {
		assertEquals("January 1, 1900", d1.toString());
	}
}
