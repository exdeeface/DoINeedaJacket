package com.grae.dinaj;

import org.junit.jupiter.api.Test;

import java.io.IOException;

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
        DailyForecast df = WeatherTestApplication.requestFakeDailyForecast();
        Daily today = df.getTimelines().getDaily().get(0);
        assertEquals("Monday, August 28", today.getTime());
        today = df.getTimelines().getDaily().get(1);
        assertEquals("Tuesday, August 29", today.getTime());
        today = df.getTimelines().getDaily().get(2);
        assertEquals("Wednesday, August 30", today.getTime());
        today = df.getTimelines().getDaily().get(3);
        assertEquals("Thursday, August 31", today.getTime());
        today = df.getTimelines().getDaily().get(4);
        assertEquals("Friday, September 1", today.getTime());
    }
}