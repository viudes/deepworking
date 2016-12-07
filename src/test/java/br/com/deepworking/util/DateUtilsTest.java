package br.com.deepworking.util;

import static org.junit.Assert.assertEquals;

import java.time.Month;
import java.time.OffsetDateTime;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import br.com.deepworking.project.model.SimpleTime;

public class DateUtilsTest {

    @Test
    public void shouldConvertToOffsetDateTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(2016, Calendar.DECEMBER, 31);

        SimpleTime time = new SimpleTime("14:45:12");

        OffsetDateTime offsetDateTime = DateUtils
                .getOffsetDateTimeFromDateAndTime(cal.getTime(), time);

        assertEquals(2016, offsetDateTime.getYear());
        assertEquals(Month.DECEMBER, offsetDateTime.getMonth());
        assertEquals(31, offsetDateTime.getDayOfMonth());
        assertEquals(14, offsetDateTime.getHour());
        assertEquals(45, offsetDateTime.getMinute());
        assertEquals(12, offsetDateTime.getSecond());

    }

    @Test
    public void shouldConvertToDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(2016, Calendar.DECEMBER, 31);

        SimpleTime time = new SimpleTime("14:45:12");

        OffsetDateTime offsetDateTime = DateUtils
                .getOffsetDateTimeFromDateAndTime(cal.getTime(), time);

        Date date = DateUtils.getDateFromOffsetDateTime(offsetDateTime);
        Calendar result = Calendar.getInstance();
        result.setTime(date);

        assertEquals(2016, result.get(Calendar.YEAR));
        assertEquals(Calendar.DECEMBER, result.get(Calendar.MONTH));
        assertEquals(31, result.get(Calendar.DAY_OF_MONTH));
        assertEquals(14, result.get(Calendar.HOUR_OF_DAY));
        assertEquals(45, result.get(Calendar.MINUTE));
        assertEquals(12, result.get(Calendar.SECOND));

    }

    @Test
    public void shouldConvertToSimpleTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(2016, Calendar.DECEMBER, 31);

        SimpleTime time = new SimpleTime("14:45:12");

        OffsetDateTime offsetDateTime = DateUtils
                .getOffsetDateTimeFromDateAndTime(cal.getTime(), time);

        SimpleTime simpleTime = DateUtils.getSimpleTimeFromOffsetDateTime(offsetDateTime);
        assertEquals(14, simpleTime.getHour());
        assertEquals(45, simpleTime.getMinute());
        assertEquals(12, simpleTime.getSecond());
    }
}
