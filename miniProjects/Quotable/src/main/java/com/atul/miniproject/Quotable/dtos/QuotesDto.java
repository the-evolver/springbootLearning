package com.atul.miniproject.Quotable.dtos;


import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class QuotesDto {

    private final Integer id;
    private final String quote;
    private final String year;
}
