package com.atul.miniproject.Quotable.clients;


import com.atul.miniproject.Quotable.dtos.QuotesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public class KimiQuotesRestClient {

    private final RestClient restClient;

    public QuotesDto getRandomQuote(){
        return restClient.get()
                .uri("/quote")
                .retrieve()
                .body(QuotesDto.class);
    }
}
