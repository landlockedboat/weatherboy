package com.ferns.weatherboy;

import lombok.Data;

@Data
public class Forecast {
    private String condition;
    private Float temperature;


    public Forecast(String condition, Float temperature) {
        this.condition = condition;
        this.temperature = temperature;
    }
}
