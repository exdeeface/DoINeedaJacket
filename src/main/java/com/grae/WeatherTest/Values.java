package com.grae.WeatherTest;

import java.text.DecimalFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Values {

    DecimalFormat df = new DecimalFormat("0.0");

    private double cloudCover;
    private double humidity;
    private double temperature;
    private double temperatureApparent;
    private double cloudCoverAvg;
    private double humidityAvg;
    public double precipitationProbabilityAvg;
    private int precipitationProbabilityMax;
    private int snowIntensityAvg;
    private double temperatureApparentAvg;
    private double temperatureAvg;
    private double windSpeed;
    private double windSpeedAvg;
    private int precipitationProbability;
    private double rainAccumulation;
    private double rainIntensity;
    private double cloudCoverMax;
    private int cloudCoverMin;
    private double humidityMax;
    private double humidityMin;
    private int iceAccumulationSum;
    private int precipitationProbabilityMin;
    private int rainAccumulationAvg;
    private int rainAccumulationLweAvg;
    private double rainAccumulationLweMax;
    private int rainAccumulationLweMin;
    private double rainAccumulationMax;
    private int rainAccumulationMin;
    private double rainAccumulationSum;
    private int rainIntensityAvg;
    private double rainIntensityMax;
    private int rainIntensityMin;
    private double temperatureApparentMax;
    private double temperatureApparentMin;
    private double temperatureMax;
    private double temperatureMin;
    private double windSpeedMax;
    private double windSpeedMin;

    public double getCloudCoverAvg() { return cloudCoverAvg; }
    public int getPrecipitationProbabilityMax() { return precipitationProbabilityMax; }
    public double getWindSpeedAvg() { return windSpeedAvg; }
    public double getTemperatureAvg() {
        return temperatureAvg;
    }
    public String getTemperatureApparentAvgAsString() { return df.format(this.temperatureApparentAvg); }
    public double getTemperatureApparentAvg() {
        return this.temperatureApparentAvg;
    }
}