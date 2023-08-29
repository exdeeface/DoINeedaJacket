package com.grae.Weather;

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
        assertEquals(today.getTime(), "Monday, August 28");
        today = df.getTimelines().getDaily().get(1);
        assertEquals(today.getTime(), "Tuesday, August 29");
        today = df.getTimelines().getDaily().get(2);
        assertEquals(today.getTime(), "Wednesday, August 30");
        today = df.getTimelines().getDaily().get(3);
        assertEquals(today.getTime(), "Thursday, August 31");
        today = df.getTimelines().getDaily().get(4);
        assertEquals(today.getTime(), "Friday, September 1");
    }
}