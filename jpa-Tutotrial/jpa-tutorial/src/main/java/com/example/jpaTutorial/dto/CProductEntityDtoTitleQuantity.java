package com.example.jpaTutorial.dto;

import lombok.Data;

@Data
public class CProductEntityDtoTitleQuantity {
    private final String title;
    private final int quantity;


    public CProductEntityDtoTitleQuantity(String title, int quantity) {
        this.title = title;
        this.quantity = quantity;
    }
}
