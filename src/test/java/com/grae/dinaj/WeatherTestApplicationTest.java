package com.grae.dinaj;

import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WeatherTestApplicationTest {

    @Test
    void requestDailyForecast() throws IOException, InterruptedException {
        DailyForecast df = WeatherTestApplication.requestDailyForecast("Brixton");
        assertAll(
                () -> assertEquals("Brixton, London, Greater London, England, SW2 1SS, United Kingdom", df.getLocation().getName()),
                () -> assertEquals("51.456806", df.getLocation().getLat()),
                () -> assertEquals("-0.116796", df.getLocation().getLon()),
                () -> assertEquals(5, df.getTimelines().getDaily().size()),
                () -> assertEquals("town", df.getLocation().getType()),
                () -> assertNull(WeatherTestApplication.requestDailyForecast("").getTimelines())
        );
    }

    @Test
    void testRequestDailyForecast() throws IOException {
        DailyForecast df = WeatherTestApplication.requestFakeDailyForecast();
        assertEquals("Eferding, Bezirk Eferding, 4070, Österreich", df.getLocation().getName());
    }
}