package com.grae.WeatherTest;

import java.text.DecimalFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Values {

    DecimalFormat df = new DecimalFormat("0.0");

    public double cloudBase;
    public double cloudCeiling;
    public double cloudCover;
    public double dewPoint;
    public double evapotranspiration;
    public int freezingRainIntensity;
    public double humidity;
    public int iceAccumulation;
    public int iceAccumulationLwe;
    public int precipitationProbability;
    public double pressureSurfaceLevel;
    public double rainAccumulation;
    public double rainAccumulationLwe;
    public double rainIntensity;
    public int sleetAccumulation;
    public int sleetAccumulationLwe;
    public int sleetIntensity;
    public int snowAccumulation;
    public int snowAccumulationLwe;
    public int snowIntensity;
    public double temperature;
    public double temperatureApparent;
    public int uvHealthConcern;
    public int uvIndex;
    public double visibility;
    public int weatherCode;
    public double windDirection;
    public double windGust;

    public double cloudBaseAvg;
    public double cloudBaseMax;
    public int cloudBaseMin;
    public double cloudCeilingAvg;
    public double cloudCeilingMax;
    public int cloudCeilingMin;
    public double cloudCoverAvg;
    public double cloudCoverMax;
    public int cloudCoverMin;
    public double dewPointAvg;
    public double dewPointMax;
    public double dewPointMin;
    public double evapotranspirationAvg;
    public double evapotranspirationMax;
    public double evapotranspirationMin;
    public double evapotranspirationSum;
    public int freezingRainIntensityAvg;
    public int freezingRainIntensityMax;
    public int freezingRainIntensityMin;
    public double humidityAvg;
    public double humidityMax;
    public double humidityMin;
    public int iceAccumulationAvg;
    public int iceAccumulationLweAvg;
    public int iceAccumulationLweMax;
    public int iceAccumulationLweMin;
    public int iceAccumulationLweSum;
    public int iceAccumulationMax;
    public int iceAccumulationMin;
    public int iceAccumulationSum;
    public Date moonriseTime;
    public Date moonsetTime;
    public double precipitationProbabilityAvg;
    public int precipitationProbabilityMax;
    public int precipitationProbabilityMin;
    public double pressureSurfaceLevelAvg;
    public double pressureSurfaceLevelMax;
    public double pressureSurfaceLevelMin;
    public int rainAccumulationAvg;
    public int rainAccumulationLweAvg;
    public double rainAccumulationLweMax;
    public int rainAccumulationLweMin;
    public double rainAccumulationMax;
    public int rainAccumulationMin;
    public double rainAccumulationSum;
    public int rainIntensityAvg;
    public double rainIntensityMax;
    public int rainIntensityMin;
    public int sleetAccumulationAvg;
    public int sleetAccumulationLweAvg;
    public int sleetAccumulationLweMax;
    public int sleetAccumulationLweMin;
    public int sleetAccumulationLweSum;
    public int sleetAccumulationMax;
    public int sleetAccumulationMin;
    public int sleetIntensityAvg;
    public int sleetIntensityMax;
    public int sleetIntensityMin;
    public int snowAccumulationAvg;
    public int snowAccumulationLweAvg;
    public int snowAccumulationLweMax;
    public int snowAccumulationLweMin;
    public int snowAccumulationLweSum;
    public int snowAccumulationMax;
    public int snowAccumulationMin;
    public int snowAccumulationSum;
    public int snowIntensityAvg;
    public int snowIntensityMax;
    public int snowIntensityMin;
    public Date sunriseTime;
    public Date sunsetTime;
    public double temperatureApparentAvg;
    public double temperatureApparentMax;
    public double temperatureApparentMin;
    public double temperatureAvg;
    public double temperatureMax;
    public double temperatureMin;
    public int uvHealthConcernAvg;
    public int uvHealthConcernMax;
    public int uvHealthConcernMin;
    public int uvIndexAvg;
    public int uvIndexMax;
    public int uvIndexMin;
    public double visibilityAvg;
    public double visibilityMax;
    public double visibilityMin;
    public int weatherCodeMax;
    public int weatherCodeMin;
    public double windDirectionAvg;
    public double windGustAvg;
    public double windGustMax;
    public double windGustMin;
    public double windSpeedAvg;
    public double windSpeedMax;
    public double windSpeedMin;

    public double getCloudCeilingAvg() {
        return cloudCeilingAvg;
    }

    public double getHumidityAvg() {
        return humidityAvg;
    }

    public Date getMoonriseTime() {
        return moonriseTime;
    }

    public Date getMoonsetTime() {
        return moonsetTime;
    }

    public int getSnowIntensityAvg() {
        return snowIntensityAvg;
    }

    public Date getSunriseTime() {
        return sunriseTime;
    }

    public Date getSunsetTime() {
        return sunsetTime;
    }

    public double getTemperatureAvg() {
        return temperatureAvg;
    }

    public int getUvIndexAvg() {
        return uvIndexAvg;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double windSpeed;

    public double getTemperature() {
        return temperature;
    }

    public double getTemperatureApparent() {
        return temperatureApparent;
    }

    public String getTemperatureApparentAvg() {
        return df.format(this.temperatureApparentAvg);
    }
}