package com.atul.miniproject.Quotable.clients;

import com.atul.miniproject.Quotable.dtos.QuotesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
public class KimiQuotesWebClient {

    private final WebClient webClient;

    public QuotesDto getRandomQuote(){
        return webClient.get()
                .uri("/quote")
                .retrieve()
                .bodyToMono(QuotesDto.class)
                .block();
    }

}
