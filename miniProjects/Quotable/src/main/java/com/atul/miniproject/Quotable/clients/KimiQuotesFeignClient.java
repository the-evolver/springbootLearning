package com.atul.miniproject.Quotable.clients;


import com.atul.miniproject.Quotable.dtos.QuotesDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "quotesFeign" ,url = "https://kimiquotes.pages.dev/api")
public interface KimiQuotesFeignClient {

    @GetMapping("/quote")
    QuotesDto getRandomQuote();
}
