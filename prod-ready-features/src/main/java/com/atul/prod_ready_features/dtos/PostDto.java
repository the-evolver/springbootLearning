package com.atul.prod_ready_features.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {

    private Long id;
    private String title;
    private String description;
    private String operation;
    private LocalDateTime updateTime;
}
