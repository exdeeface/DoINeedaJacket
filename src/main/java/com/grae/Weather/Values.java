package com.grae.Weather;

import java.text.DecimalFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class Values {

    DecimalFormat df = new DecimalFormat("0.0");

    private double cloudCoverAvg;
    private int precipitationProbabilityMax;
    private double windSpeedAvg;
    private double temperatureAvg;
    private double temperatureApparentAvg;

    public double getCloudCoverAvg() { return cloudCoverAvg; }
    public int getPrecipitationProbabilityMax() { return precipitationProbabilityMax; }
    public double getWindSpeedAvg() { return windSpeedAvg; }
    public double getTemperatureAvg() { return temperatureAvg; }
    public String getTemperatureApparentAvgAsString() { return df.format(this.temperatureApparentAvg); }
    public double getTemperatureApparentAvg() { return this.temperatureApparentAvg; }
}
