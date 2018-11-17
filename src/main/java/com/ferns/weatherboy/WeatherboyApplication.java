package com.ferns.weatherboy;

import com.ferns.weatherboy.openweather.OpenWeatherForecast;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

@SpringBootApplication
@RestController
public class WeatherboyApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherboyApplication.class, args);
    }

    private static final String REST_URI
            = "https://api.openweathermap.org/data/2.5/weather?units=metric&appid=a41457dbeffaeb62ebaebabb7ba1f129";
    private static final String DEFAULT_CITY = "Barcelona";
    private Client client = ClientBuilder.newClient();

    @GetMapping("")
    public Greeting getGreeting(){
        return new Greeting();
    }

    @GetMapping("/weather")
    public Forecast getDefaultWeather() {
        return getWeatherByCityName(DEFAULT_CITY);
    }

    @GetMapping("/weather/{city}")
    public Forecast getWeatherByCityName(@PathVariable String city) {
        try {
            OpenWeatherForecast openweatherForecast = client
                    .target(REST_URI + "&q=" + city)
                    .request(MediaType.APPLICATION_JSON)
                    .get(OpenWeatherForecast.class);

            return new Forecast(
                    openweatherForecast.getWeather().get(0).getDescription(),
                    openweatherForecast.getMain().getTemp());
        } catch (NotFoundException e) {
            throw new NotFoundException("The desired city could not be found.");
        } catch (Exception e) {
            throw new InternalServerErrorException(
                    "An error occurred processing your request.");
        }
    }
}
