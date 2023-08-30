package com.grae.dinaj;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.*;

class DailyTest {
    @Test
    void summariseData() throws IOException {
        Daily day = new Daily();

        assertAll(
                () -> {
                    assertNull(day.getSummary());
                    assertNull(day.getJustification());
                    assertNull(day.getDoINeedAJacket());
                }

        );

        Daily test = WeatherTestApplication.requestFakeDailyForecast().getTimelines().getDaily().get(0);

        test.summariseData();

        assertAll(
                () -> {
                    assertNotNull(test.getSummary());
                    assertNotNull(test.getJustification());
                    assertNotNull(test.getDoINeedAJacket());
                }
        );
    }

    @Test
    void getTime(){
        assertAll(
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.JANUARY, 1);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals("Sunday, January 1", day.getTime());
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.FEBRUARY, 16);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals("Thursday, February 16", day.getTime());
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.MARCH, 28);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals("Tuesday, March 28", day.getTime());
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.APRIL, 3);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals("Monday, April 3", day.getTime());
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.MAY, 19);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals("Friday, May 19", day.getTime());
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.JUNE, 20);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals("Tuesday, June 20", day.getTime());
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.JULY, 26);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals("Wednesday, July 26", day.getTime());
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.AUGUST, 19);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals("Saturday, August 19", day.getTime());
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.SEPTEMBER, 15);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals("Friday, September 15", day.getTime());
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.OCTOBER, 28);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals("Saturday, October 28", day.getTime());
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.NOVEMBER, 7);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals("Tuesday, November 7", day.getTime());
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.DECEMBER, 18);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals("Monday, December 18", day.getTime());
                }
        );
    }

    @Test
    void doINeedAJacket() {
        assertAll(
                () -> {
                    Daily day = new Daily();
                    day.setValues(new Values());
                    day.getValues().setTemperatureApparentAvg(5.0d);
                    day.calcColdScore();
                    assertEquals(-2, day.getColdScore());
                },
                () -> {
                    Daily day = new Daily();
                    day.setValues(new Values());
                    day.getValues().setTemperatureApparentAvg(13.8d);
                    day.calcColdScore();
                    assertEquals(-1, day.getColdScore());
                },
                () -> {
                    Daily day = new Daily();
                    day.setValues(new Values());
                    day.getValues().setTemperatureApparentAvg(16.6d);
                    day.calcColdScore();
                    assertEquals(0, day.getColdScore());
                },
                () -> {
                    Daily day = new Daily();
                    day.setValues(new Values());
                    day.getValues().setTemperatureApparentAvg(21.1d);
                    day.calcColdScore();
                    assertEquals(1, day.getColdScore());
                },
                () -> {
                    Daily day = new Daily();
                    day.setValues(new Values());
                    day.getValues().setTemperatureApparentAvg(29.3d);
                    day.calcColdScore();
                    assertEquals(2, day.getColdScore());
                }
        );
    }
}