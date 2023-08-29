package com.grae.WeatherTest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Timelines {
    private ArrayList<Hourly> hourly;
    private ArrayList<Daily> daily;

    public ArrayList<Hourly> getHourly() { return hourly; }
    public ArrayList<Daily> getDaily() {
        return daily;
    }
}
