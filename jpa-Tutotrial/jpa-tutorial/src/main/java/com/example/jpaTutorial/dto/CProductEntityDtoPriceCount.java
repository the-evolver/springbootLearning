package com.example.jpaTutorial.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CProductEntityDtoPriceCount {

    private final BigDecimal price;
    private final Long count;



    public CProductEntityDtoPriceCount(BigDecimal price, Long count) {
        this.price = price;
        this.count = count;
    }
}
