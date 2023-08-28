package com.grae.WeatherTest;

import org.checkerframework.checker.units.qual.C;

import java.util.Calendar;
import java.util.Date;

public class Daily {
    public Date time;
    public Values values;
    public String verdict;

    public Values getValues() {
        return this.values;
    }

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

    public void makeVerdict() {
        if (values.cloudBaseAvg < 0.4d && values.temperatureAvg > 21.0d && values.rainIntensityAvg < 0.1d) {
            this.verdict = "Sunny";
        } else if (values.windSpeedAvg > 10.0d) {
            this.verdict = "Windy";
        } else if (values.cloudBaseAvg > 0.6d && values.rainIntensityAvg < 0.1d) {
            this.verdict = "Cloudy";
        } else if (values.rainIntensityAvg > 0.6d) {
            this.verdict = "Rainy";
        } else {
            this.verdict = "You forgot something.";
        }
    }

    public String getVerdict() {
        makeVerdict();
        return verdict;
    }
}