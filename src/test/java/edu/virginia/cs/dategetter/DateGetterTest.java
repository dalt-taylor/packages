package edu.virginia.cs.dategetter;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DateGetterTest {
    @Test
    public void testDateAsOfWriting() {
        DateGetter dg = new DateGetter();
        Date date = dg.getDate(2022, 8, 10);
        assertEquals(2022, date.getYear());
        assertEquals(8, date.getMonth());
        assertEquals(10, date.getDay());
    }

    @Test
    public void testGetFirstDayOf2000() {
        DateGetter dg = new DateGetter();
        Date date = dg.getDate(2000, 1, 1);
        assertEquals(2000, date.getYear());
        assertEquals(1, date.getMonth());
        assertEquals(1, date.getDay());
    }

    @Test
    public void testGetLastDayOf1999() {
        DateGetter dg = new DateGetter();
        Date date = dg.getDate(1999, 12, 31);
        assertEquals(1999, date.getYear());
        assertEquals(12, date.getMonth());
        assertEquals(31, date.getDay());
    }

    @Test
    public void getMonthDayYear() {
        DateImpl myDate = new DateImpl(2022, 8, 10);
        DateGetter dg = new DateGetter();
        assertEquals("8-10-2022", dg.getMonthDayYearDate(myDate));
    }

    @Test
    public void testIsValidDateWithRealDate() {
        DateGetter dg = new DateGetter();
        assertTrue(dg.isValidDate(2022, 8, 10));
    }

    @Test
    public void testIsValidDateWithBadDate() {
        DateGetter dg = new DateGetter();
        assertFalse(dg.isValidDate(2022, 8, 32));
    }
}
