package com.atul.prod_ready_features.clients;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class Weather {

    private final RestTemplate restTemplate;

    public String getWeather(String url){
        System.out.println("Rest template => "+ restTemplate.toString());
        return restTemplate.getForObject(url,String.class);
    }

}
