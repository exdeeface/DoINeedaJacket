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
        DailyForecast df = WeatherTestApplication.requestDailyForecast("se11aa");
    }
}