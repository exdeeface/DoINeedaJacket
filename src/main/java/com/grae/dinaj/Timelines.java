package com.grae.dinaj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Timelines {
    private ArrayList<Daily> daily;

    public List<Daily> getDaily() {
        return daily;
    }
}
