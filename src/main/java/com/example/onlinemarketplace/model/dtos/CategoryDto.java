package com.example.onlinemarketplace.model.dtos;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CategoryDto {
    private Long id;

    private String name;

    private String description;

    private LocalDateTime lastModifiedAt;

    private ParentCategory parentCategory;

    private List<Product> products;

    @Getter
    @AllArgsConstructor
    @EqualsAndHashCode
    @ToString
    public static class ParentCategory {
        private Long id;

        private String name;
    }

    @Getter
    @AllArgsConstructor
    @EqualsAndHashCode
    @ToString
    public static class Product {
        private Long id;

        private String name;

    }
}
