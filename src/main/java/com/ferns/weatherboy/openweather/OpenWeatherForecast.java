package com.ferns.weatherboy.openweather;

import lombok.Data;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
public class OpenWeatherForecast {
    private Coord coord;
    private ArrayList<Weather> weather = new ArrayList<>();
    private String base;
    private Main main;
    private float visibility;
    private Wind wind;
    private Clouds clouds;
    private float dt;
    private Sys sys;
    private float id;
    private String name;
    private float cod;
}

