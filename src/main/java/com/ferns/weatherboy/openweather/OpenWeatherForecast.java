package com.ferns.weatherboy.openweather;

import com.ferns.weatherboy.Main;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OpenWeatherForecast {
    public Coord coord;
    public ArrayList<Weather> weather = new ArrayList<>();
    public String base;
    public Main main;
    public float visibility;
    public Wind wind;
    public Clouds clouds;
    public float dt;
    public Sys sys;
    public float id;
    public String name;
    public float cod;
}

