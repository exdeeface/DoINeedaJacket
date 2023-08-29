package com.grae.dinaj;

import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ResponseHandler {

    private ResponseHandler() {

    }

    static Map<String, Object> context = Maps.newHashMap();

    public static String createTemplate(DailyForecast dailyForecast) throws IOException {
        var jnj = new Jinjava();

        context.put("dailyForecast", dailyForecast);
        context.put("today", dailyForecast.getTimelines().getDaily().get(0));
        context.put("feelsLike", dailyForecast.getTimelines().getDaily().get(0).getValues().getTemperatureApparentAvgAsString());

        String template = Resources.toString(Resources.getResource("getWeather.html"), StandardCharsets.UTF_8);
        return jnj.render(template, context);

    }
}
