package com.atul.prod_ready_features;

import com.atul.prod_ready_features.clients.RestTemplateWeather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ThirdPartyApiTest {
    @Autowired
    private RestTemplateWeather weather;
    @Test
    void WeatherTest(){

        String url = "https://api.open-meteo.com/v1/forecast?latitude=28.61&longitude=77.23&current_weather=true";
        System.out.println("Response => "+ weather.getWeather(url));

    }
}