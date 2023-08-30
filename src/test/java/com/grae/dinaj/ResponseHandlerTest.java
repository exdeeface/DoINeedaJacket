package com.grae.dinaj;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ResponseHandlerTest {
    @Test
    void createTemplate() throws IOException {
        DailyForecast df = WeatherTestApplication.requestFakeDailyForecast();
        String s = ResponseHandler.createTemplate(df);
        assertAll(
                () -> assertTrue(s.contains("<title>Weather Forecast</title")),
                () -> assertTrue(s.contains("It's mild out, and there's a strong chance it will rain.")),
                () -> assertTrue(s.contains("Eferding, Bezirk Eferding, 4070, Österreich"))
        );
    }
}