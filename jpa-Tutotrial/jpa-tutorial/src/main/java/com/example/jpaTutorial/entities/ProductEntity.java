package com.example.jpaTutorial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "atul_prod",
       uniqueConstraints = {
        @UniqueConstraint(name = "sku_unique" ,columnNames = {"sku"}),
        @UniqueConstraint(name = "title_price_unique" ,columnNames = {"product_title","price"})
       }

     )
public class ProductEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false,length = 50)
    private String sku;

    @Column(name = "product_title")
    private String title;

    private BigDecimal price;

    private Integer quantity;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalTime updatedAt;

}
