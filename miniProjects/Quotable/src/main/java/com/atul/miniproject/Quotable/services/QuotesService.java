package com.atul.miniproject.Quotable.services;

import com.atul.miniproject.Quotable.clients.kimiQuotesClient;
import com.atul.miniproject.Quotable.dtos.QuotesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuotesService {
    private final kimiQuotesClient quotesClinet;

    public QuotesDto getRandomQuotes() {
        QuotesDto response = quotesClinet.getRandomQuote();
        System.out.println("Response => "+response);
        return response;
    }
}
