package com.atul.prod_ready_features.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(name="weather",url="https://api.open-meteo.com")
public interface OpenFeignWeatherClient {

    @GetMapping(path = "/weather")
    String getWeather();

}
