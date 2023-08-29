package com.grae.Weather;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;

import java.io.IOException;
import java.util.Map;

public class ResponseHandler {
    static Map<String, Object> context = Maps.newHashMap();

    public static String createTemplate(DailyForecast dailyForecast) throws IOException {
        var jnj = new Jinjava();

        context.put("dailyForecast", dailyForecast);
        context.put("today", dailyForecast.getTimelines().getDaily().get(0));
        context.put("feelsLike", dailyForecast.getTimelines().getDaily().get(0).getValues().getTemperatureApparentAvgAsString());

        String template = Resources.toString(Resources.getResource("getWeather.html"), Charsets.UTF_8);
        return jnj.render(template, context);

    }
}
