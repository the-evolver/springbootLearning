package com.atul.prod_ready_features.clients;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebClientWeather {

    private final WebClient webClient;

    public WebClientWeather(WebClient webClient) {
        this.webClient = webClient;
    }

    public String getWeather() {

        String res = String.valueOf(webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/forecast")
                        .queryParam("latitude", "28.61")
                        .queryParam("longitude", "77.23")
                        .queryParam("current_weather", "true")
                        .build())
                .retrieve()
                .bodyToMono(String.class));


        return res;
    }
}