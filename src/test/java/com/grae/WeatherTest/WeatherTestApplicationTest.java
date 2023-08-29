package com.grae.WeatherTest;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class WeatherTestApplicationTest {

    @Test
    void requestDailyForecast() throws IOException, InterruptedException {
        assertAll(
                () -> {
                    if (System.getenv("X_RAPIDAPI_KEY") != null) {
                        assertEquals("Brixton, London, Greater London, England, SW2 1SS, United Kingdom",
                                WeatherTestApplication.requestDailyForecast("Brixton").getLocation().getName());
                    }
                },
                () -> {
                    assertNull(WeatherTestApplication.requestDailyForecast("").getTimelines());
                }
        );
    }

    @Test
    void testRequestDailyForecast() throws IOException {
        DailyForecast dailyForecast = WeatherTestApplication.requestFakeDailyForecast();
        assertEquals("Eferding, Bezirk Eferding, 4070, Österreich", dailyForecast.getLocation().getName());
    }
}