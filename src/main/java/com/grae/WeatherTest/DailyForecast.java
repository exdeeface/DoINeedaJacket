package com.grae.WeatherTest;

public class DailyForecast {
    public Timelines timelines;
    public Location location;
    public String verdict;
    public String justification;

    public Timelines getTimelines() {
        return timelines;
    }
    public Location getLocation() {
        return location;
    }
    public String getVerdict() {
        return "You don't need a jacket.";
    }

    public String getJustification() {
        return "It's warm out, and there's no wind.";
    }
}
