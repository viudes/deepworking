package br.com.deepworking.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import br.com.deepworking.project.model.SimpleTime;

public class DateUtils {

    public static OffsetDateTime getOffsetDateTimeFromDateAndTime(Date date, SimpleTime time) {
        if (date == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        LocalDate localDate = LocalDate.of(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH));

        LocalTime localTime = LocalTime.of(time.getHour(), time.getMinute(), time.getSecond());
        ZonedDateTime zdt = ZonedDateTime.of(localDate, localTime, ZoneId.systemDefault());

        return OffsetDateTime.of(localDate, localTime, zdt.getOffset());
    }

    public static Date getDateFromOffsetDateTime(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }

        return Date.from(offsetDateTime.atZoneSameInstant(offsetDateTime.getOffset()).toInstant());
    }

    public static SimpleTime getSimpleTimeFromOffsetDateTime(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }

        return new SimpleTime(offsetDateTime.getHour(), offsetDateTime.getMinute(), offsetDateTime.getSecond());
    }
}
