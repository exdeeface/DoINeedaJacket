package com.grae.Weather;

import java.text.DecimalFormat;

public class Location {
    DecimalFormat df = new DecimalFormat("0.000000");

    private double lat;
    private double lon;
    private String name;
    private String type;

    public String getLat() { return df.format(lat); }
    public String getLon() { return df.format(lon);}
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
}