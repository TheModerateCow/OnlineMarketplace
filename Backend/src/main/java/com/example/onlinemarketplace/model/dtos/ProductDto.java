package com.example.onlinemarketplace.model.dtos;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductDto {
    private Long id;

    private String product_name;

    private BigDecimal product_price;

    private String product_description;

    private String category_name;

    private LocalDateTime created_at;

    private LocalDateTime last_modified_at;
}
