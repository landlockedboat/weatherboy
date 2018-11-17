package com.ferns.weatherboy.openweather;

import lombok.Data;

@Data
public class Weather{
    private float id;
    private String main;
    private String description;
    private String icon;
}
