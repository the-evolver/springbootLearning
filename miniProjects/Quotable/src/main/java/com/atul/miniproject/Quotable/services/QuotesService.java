package com.atul.miniproject.Quotable.services;

import com.atul.miniproject.Quotable.clients.KimiQuotesFeignClient;
import com.atul.miniproject.Quotable.clients.KimiQuotesRestClient;
import com.atul.miniproject.Quotable.clients.KimiQuotesWebClient;
import com.atul.miniproject.Quotable.dtos.QuotesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuotesService {
    private final KimiQuotesRestClient kimiQuotesRestClient;
    private final KimiQuotesWebClient kimiQuotesWebClient;

    private final KimiQuotesFeignClient kimiQuotesFeignClient;

    public QuotesDto getRandomQuotes(String client) {
        QuotesDto response;

        if("RestClient".equals(client)){
            System.out.println("It is a rest client request .. Got to know from parameters ... Serving ");
            response = kimiQuotesRestClient.getRandomQuote();
            response.setClient("RestClient");
        }else if("WebClient".equals(client)) {
            System.out.println("It is a Web client request .. Got to know from parameters ... Serving ");
            response = kimiQuotesWebClient.getRandomQuote();
            response.setClient("Web Client");
        }else{
            System.out.println("It is a Feign client request .. Got to know from parameters ... Serving ");
            response = kimiQuotesFeignClient.getRandomQuote();
            response.setClient("Feign Client");
        }


        System.out.println("Response => "+response);
        return response;
    }
}
