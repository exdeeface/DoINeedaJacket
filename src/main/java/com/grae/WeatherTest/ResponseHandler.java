package com.grae.WeatherTest;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;

import java.io.IOException;
import java.util.Map;

public class ResponseHandler {
    static Map<String, Object> context = Maps.newHashMap();

    public String createTemplate(HourlyForecast hourlyForecast) throws IOException {
        var jnj = new Jinjava();

        context.put("hourlyForecast", hourlyForecast);

        String template = Resources.toString(Resources.getResource("getWeather.html"), Charsets.UTF_8);
        return jnj.render(template, context);
    }

    public String createTemplate(DailyForecast dailyForecast) throws IOException {
        var jnj = new Jinjava();

        context.put("dailyForecast", dailyForecast);
        context.put("feelslikenow", dailyForecast.timelines.daily.get(0).values.temperatureApparentAvg);

        String template = Resources.toString(Resources.getResource("getWeather.html"), Charsets.UTF_8);
        return jnj.render(template, context);

    }
}
