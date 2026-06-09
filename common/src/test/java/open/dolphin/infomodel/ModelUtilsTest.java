package open.dolphin.infomodel;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ModelUtilsTest {

    @Test
    public void testTrimTimeAndTrimDate() {
        assertEquals("2024-06-09", ModelUtils.trimTime("2024-06-09T12:34:56"));
        assertEquals("12:34", ModelUtils.trimDate("2024-06-09T12:34:56"));
        assertEquals("2024-06-09", ModelUtils.trimTime("2024-06-09"));
        assertEquals("2024-06-09", ModelUtils.trimDate("2024-06-09"));
    }

    @Test
    public void testGetCalendarAndDates() {
        Calendar cal = ModelUtils.getCalendar("2020-01-02");
        assertNotNull(cal);
        assertEquals(2020, cal.get(Calendar.YEAR));
        assertEquals(0, cal.get(Calendar.MONTH));
        assertEquals(2, cal.get(Calendar.DAY_OF_MONTH));

        Date date = ModelUtils.getDateAsObject("2020-01-02");
        assertNotNull(date);
        assertEquals("2020-01-02", ModelUtils.getDateAsString(date));

        Date dateTime = ModelUtils.getDateTimeAsObject("2020-01-02T03:04:05");
        assertNotNull(dateTime);
        assertEquals("2020-01-02T03:04:05", ModelUtils.getDateTimeAsString(dateTime));
    }

    @Test
    public void testGenderDescriptions() {
        assertNotNull(ModelUtils.getGenderDesc("M"));
        assertNotNull(ModelUtils.getGenderDesc("F"));
        assertNotNull(ModelUtils.getGenderDesc("X"));
    }
}
