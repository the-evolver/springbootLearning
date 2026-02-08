package com.atul.miniproject.Quotable.controllers;

import com.atul.miniproject.Quotable.dtos.QuotesDto;
import com.atul.miniproject.Quotable.services.QuotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QuotesController {

    private final QuotesService quotesService;

    @GetMapping(path = "/quotes/random")
    QuotesDto getRandomQuotes(@RequestParam(name = "client" , required = false) String client){
          return quotesService.getRandomQuotes(client);

    }
}
