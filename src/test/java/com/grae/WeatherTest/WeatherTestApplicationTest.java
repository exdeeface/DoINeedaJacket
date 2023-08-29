package com.grae.WeatherTest;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherTestApplicationTest {

    @Test
    void requestDailyForecast() throws IOException {
        DailyForecast df = WeatherTestApplication.requestDailyForecast("Brixton");
        assertEquals("Brixton, London, Greater London, England, SW2 1SS, United Kingdom", df.getLocation().getName());
    }
}