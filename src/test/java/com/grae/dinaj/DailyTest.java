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
    void getTime() throws IOException {
        assertAll(
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.JANUARY, 1);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals(day.getTime(), "Sunday, January 1");
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.FEBRUARY, 16);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals(day.getTime(), "Thursday, February 16");
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.MARCH, 28);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals(day.getTime(), "Tuesday, March 28");
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.APRIL, 3);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals(day.getTime(), "Monday, April 3");
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.MAY, 19);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals(day.getTime(), "Friday, May 19");
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.JUNE, 20);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals(day.getTime(), "Tuesday, June 20");
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.JULY, 26);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals(day.getTime(), "Wednesday, July 26");
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.AUGUST, 19);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals(day.getTime(), "Saturday, August 19");
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.SEPTEMBER, 15);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals(day.getTime(), "Friday, September 15");
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.OCTOBER, 28);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals(day.getTime(), "Saturday, October 28");
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.NOVEMBER, 7);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals(day.getTime(), "Tuesday, November 7");
                },
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.set(2023, Calendar.DECEMBER, 18);
                    Daily day = new Daily();
                    day.setTime(c.getTime());
                    assertEquals(day.getTime(), "Monday, December 18");
                }


        );
    }
}