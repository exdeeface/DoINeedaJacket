package com.grae.WeatherTest;

import org.checkerframework.checker.units.qual.C;

import java.util.Calendar;
import java.util.Date;

public class Daily {
    public Date time;
    public Values values;
    public String summary;
    public String justification = "test change me too please :-)";
    public String dinaj;

    public int coldScore;
    public int rainScore;
    public int windScore;

    Daily() {
        summariseData();
    }

    public Values getValues() {
        return this.values;
    }
    public String getDinaj() { return dinaj; }

    public String getTime() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.time);
        String day;
        String month;

        switch (c.get(Calendar.DAY_OF_WEEK)) {
            case 0 -> day = "Sunday";
            case 1 -> day = "Monday";
            case 2 -> day = "Tuesday";
            case 3 -> day = "Wednesday";
            case 4 -> day = "Thursday";
            case 5 -> day = "Friday";
            case 6 -> day = "Saturday";
            default -> { return "Date Null"; }
        }

        switch (c.get(Calendar.MONTH)) {
            case 0 -> month = "January";
            case 1 -> month = "February";
            case 2 -> month = "March";
            case 3 -> month = "April";
            case 4 -> month = "May";
            case 5 -> month = "June";
            case 6 -> month = "July";
            case 7 -> month = "August";
            case 8 -> month = "September";
            case 9 -> month = "October";
            case 10 -> month = "November";
            case 11 -> month = "December";

            default -> { return "Date Null"; }
        }

        return day + ", " + month + " " + c.get(Calendar.DAY_OF_MONTH);
    }

    public void summariseData() {
        singleWordSummary();
        calcColdScore();
        calcRainScore();
        calcWindScore();
        makeJustification();

        int total = coldScore + rainScore + windScore;
        System.out.println("total: " + total + " -- lower value means better jacket conditions");
        System.out.println("cold score: " + coldScore + ", rainscore: " + rainScore + ", windscore: " + windScore);

        if (total <= -2) { dinaj = "You need a jacket.";
        } else if (total == 0) { dinaj = "It's up to you."; }
        else if (total > 0) { dinaj = "You don't need a jacket."; }
    }

    public void singleWordSummary() {
        if (values.cloudBaseAvg < 0.3d && values.temperatureAvg > 21.0d) { this.summary = "Sunny"; }
        else if (values.windSpeedAvg > 10.0d) { this.summary = "Windy"; }
        else if (values.cloudBaseAvg > 80d && values.rainIntensityAvg < 0.1d) { this.summary = "Cloudy"; }
        else if (values.cloudBaseAvg > 0.7d && values.rainIntensityAvg > 0.5d && values.windSpeedAvg > 8.0d) { this.summary = "Stormy"; }
        else if (values.rainIntensityAvg > 0.5d) { this.summary = "Rainy"; }
        else {
            this.summary = "Check log";
            System.out.println("temp: " + values.temperatureAvg + ", cloud: " +
                    values.cloudCoverAvg + ", rain: " + values.precipitationProbabilityAvg + ", wind: " + values.windSpeedAvg);
        }
    }

    public void calcColdScore() {
        if (values.temperatureApparentAvg < 8.0d) {
            coldScore = -2;
        } else if (8.0d <= values.temperatureApparentAvg && values.temperatureApparentAvg < 15.0d) {
            coldScore = -1;
        } else if (15.0d <= values.temperatureApparentAvg && values.temperatureApparentAvg < 18.0d) {
            coldScore = 0;
        } else if (18.0d <= values.temperatureApparentAvg && values.temperatureApparentAvg < 23.0d) {
            coldScore = 1;
        } else if (23.0d <= values.temperatureApparentAvg) {
            coldScore = 2;
        }
    }

    public void calcRainScore() {
        if (values.precipitationProbabilityAvg < 0.33d) {
            rainScore = 0;
        } else if (0.33 <= values.precipitationProbabilityAvg && values.precipitationProbabilityAvg < 0.66d) {
            rainScore = -1;
        } else if (0.66d < values.precipitationProbabilityAvg) {
            rainScore = -2;
        }
    }

    public void calcWindScore() {
        if (values.windSpeedAvg < 4.0d) {
            windScore = 1;
        } else if (4.0d <= values.windSpeedAvg && values.windSpeedAvg < 8.0d) {
            windScore = 0;
        } else if (8.0d <= values.windSpeedAvg && values.windSpeedAvg < 12.0d) {
            windScore = -1;
        } else if (12.0d <= values.windSpeedAvg) {
            windScore = -2;
        }
    }

    public void makeJustification() {
        String justify1;
        switch (coldScore) {
            case -2 -> justify1 = "It's freezing out, ";
            case -1 -> justify1 = "It's cold out, ";
            case 0 -> justify1 = "It's mild out, ";
            case 1 -> justify1 = "It's warm out, ";
            case 2 -> justify1 = "It's hot out, ";

            default -> justify1 = "It's error out, ";
        }

        String justify2 = "";
            switch (rainScore) {
                case -2 -> justify2 = "and there's a strong chance it will rain.";
                case -1 -> justify2 = "and it might rain.";
                case 0 -> justify2 = "and it probably won't rain.";
        }

        justification = justify1 + justify2;
    }

    public String getJustification() { return justification; }
    public String getSummary() { return summary; }
}