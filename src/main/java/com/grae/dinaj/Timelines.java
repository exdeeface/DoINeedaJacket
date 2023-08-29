package com.grae.dinaj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Timelines {
    private ArrayList<Daily> daily;

    public ArrayList<Daily> getDaily() {
        return daily;
    }
}
