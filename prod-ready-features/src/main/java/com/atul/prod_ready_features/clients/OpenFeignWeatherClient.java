package com.atul.prod_ready_features.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name="weather",url="https://api.open-meteo.com")
public interface OpenFeignWeatherClient {

    @GetMapping(path = "/v1/forecast")
    String getWeather(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam("current_weather") boolean currentWeather

    );

}
