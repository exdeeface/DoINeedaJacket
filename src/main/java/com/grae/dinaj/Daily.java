package com.grae.dinaj;

import java.util.Calendar;
import java.util.Date;

public class Daily {
    private Date time;
    private Values values;
    private String summary;
    private String justification;
    private String doINeedAJacket;
    private int coldScore;
    private int rainScore;
    private int windScore;

    public void summariseData() {
        calcColdScore();
        calcRainScore();
        calcWindScore();
        singleWordSummary();
        doINeedAJacket();
        makeJustification();
    }

    public void calcColdScore() {
        if (values.getTemperatureApparentAvg() < 8.0d) { coldScore = -2; }
        else if (8.0d <= values.getTemperatureApparentAvg() && values.getTemperatureApparentAvg() < 15.0d) { coldScore = -1; }
        else if (15.0d <= values.getTemperatureApparentAvg() && values.getTemperatureApparentAvg() < 18.0d) { coldScore = 0; }
        else if (18.0d <= values.getTemperatureApparentAvg() && values.getTemperatureApparentAvg() < 23.0d) { coldScore = 1; }
        else if (23.0d <= values.getTemperatureApparentAvg()) { coldScore = 2; }
    }

    public void calcRainScore() {
        if (values.getPrecipitationProbabilityMax() < 20.0d) { rainScore = 0; }
        else if (20.0d <= values.getPrecipitationProbabilityMax() && values.getPrecipitationProbabilityMax() < 40.0d) { rainScore = -1; }
        else if (40.0d < values.getPrecipitationProbabilityMax()) { rainScore = -2; }
    }

    public void calcWindScore() {
        if (values.getWindSpeedAvg() < 4.0d) { windScore = 1; }
        else if (4.0d <= values.getWindSpeedAvg() && values.getWindSpeedAvg() < 8.0d) { windScore = 0; }
        else if (8.0d <= values.getWindSpeedAvg() && values.getWindSpeedAvg() < 12.0d) { windScore = -1; }
        else if (12.0d <= values.getWindSpeedAvg()) { windScore = -2; }
    }

    public void doINeedAJacket() {
        int total = coldScore + rainScore + windScore;

        if (total < 0) { doINeedAJacket = "You need a jacket.";
        } else if (total == 0) { doINeedAJacket = "It's up to you."; }
        else { doINeedAJacket = "You don't need a jacket."; }

        if (rainScore == -2 && coldScore == 2) { doINeedAJacket += ".. but you do need an umbrella."; }
        else if (rainScore == 0 && coldScore == 0) { doINeedAJacket += ".. but you can bring a jumper."; }
    }

    public void makeJustification() {
        String justifyBegin;
        switch (coldScore) {
            case -2 -> justifyBegin = "It's freezing out, ";
            case -1 -> justifyBegin = "It's cold out, ";
            case 0 -> justifyBegin = "It's mild out, ";
            case 1 -> justifyBegin = "It's warm out, ";
            case 2 -> justifyBegin = "It's hot out, ";
            default -> justifyBegin = "It's error out, ";
        }

        String justifyEnd;
            switch (rainScore) {
                case -2 -> justifyEnd = "and there's a strong chance it will rain.";
                case -1 -> justifyEnd = "and it might rain.";
                case 0 -> justifyEnd = "and it probably won't rain.";
                default -> justifyEnd = " and error.";
        }

        justification = justifyBegin + justifyEnd;
    }

    public void singleWordSummary() {
        if (values.getPrecipitationProbabilityMax() > 20.0d) { this.summary = "Rainy"; }
        else if (values.getCloudCoverAvg() > 60.0d) { this.summary = "Cloudy"; }
        else if (values.getTemperatureApparentAvg() < 15.0d) { this.summary = "Chilly"; }
        else if (values.getCloudCoverAvg() < 30.0d && values.getTemperatureApparentAvg() >= 15.0d) { this.summary = "Sunny"; }
        else { this.summary = "Clear"; }
    }

    public String getTime() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.time);
        String day;
        String month;

        switch (c.get(Calendar.DAY_OF_WEEK)) {
            case 1 -> day = "Sunday";
            case 2 -> day = "Monday";
            case 3 -> day = "Tuesday";
            case 4 -> day = "Wednesday";
            case 5 -> day = "Thursday";
            case 6 -> day = "Friday";
            case 7 -> day = "Saturday";
            default -> day = "Date Null";
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
            default -> month = "Date Null";
        }

        return day + ", " + month + " " + c.get(Calendar.DAY_OF_MONTH);
    }

    public Values getValues() { return this.values; }
    public String getJustification() { return justification; }
    public String getSummary() { return summary; }
    public String getDoINeedAJacket() { return doINeedAJacket; }
    public int getColdScore() { return coldScore; }
    public int getRainScore() { return rainScore; }
    public int getWindScore() { return windScore; }

    public void setTime(Date time) { this.time = time; }
    public void setColdScore(int coldScore) { this.coldScore = coldScore; }
    public void setRainScore(int rainScore) { this.rainScore = rainScore; }
    public void setWindScore(int windScore) { this.windScore = windScore; }
    public void setValues(Values values) { this.values = values; }
}