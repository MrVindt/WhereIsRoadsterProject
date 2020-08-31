package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoadsterInfo {
    private String earth_distance_km;
    private String mars_distance_km;
    private String speed_kph;
    private String wikipedia;
    private String video;
    private String details;
}
