package com.grae.WeatherTest;

import java.text.DecimalFormat;

public class Location {
    DecimalFormat df = new DecimalFormat("0.000000");

    public double lat;
    public double lon;
    public String name;
    public String type;

    public String getLat() {
        return df.format(lat);
    }

    public String getLon() {
        return df.format(lon);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}