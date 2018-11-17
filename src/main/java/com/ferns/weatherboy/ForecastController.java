package com.ferns.weatherboy;

import com.ferns.weatherboy.openweather.OpenWeatherForecast;
import lombok.var;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

@RestController
public class ForecastController {
    private static final String REST_URI
            = "https://api.openweathermap.org/data/2.5/weather?units=metric&appid=a41457dbeffaeb62ebaebabb7ba1f129";
    private static final String DEFAULT_CITY = "Barcelona";
    private Client client = ClientBuilder.newClient();

    @GetMapping("/weather")
    public Forecast getDefaultWeather() {
        return getWeatherByCityName(DEFAULT_CITY);
    }

    @GetMapping("/weather/{city}")
    public Forecast getWeatherByCityName(@PathVariable String city) {
        try {
            var openweatherForecast = client
                    .target(REST_URI + "&q=" + city)
                    .request(MediaType.APPLICATION_JSON)
                    .get(OpenWeatherForecast.class);

            return new Forecast(
                    openweatherForecast.weather.get(0).description,
                    openweatherForecast.main.getTemp());
        } catch (NotFoundException e) {
            throw new NotFoundException("The desired city could not be found.");
        } catch (Exception e) {
            throw new InternalServerErrorException(
                    "An error occurred processing your request.");
        }
    }
}
