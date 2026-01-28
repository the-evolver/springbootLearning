package com.example.jpaTutorial.dto;

import lombok.Data;

@Data
public class CProductEntityDtoTitleCount {
    private final String title;
    private final Long count;



    public CProductEntityDtoTitleCount(String title, Long count) {
        this.title = title;
        this.count = count;
    }
}
