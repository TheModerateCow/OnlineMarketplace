package com.example.onlinemarketplace.model.dtos;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    private LocalDateTime createdAt;

    private ParentCategory parentCategory;

    private List<Product> products = new ArrayList<>();

    public CategoryDto(Long id, String name, String description, LocalDateTime lastModifiedAt, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lastModifiedAt = lastModifiedAt;
        this.createdAt = createdAt;
    }

    public void addParentCategory(Long id, String name){
        this.parentCategory = new ParentCategory(id, name);
    }

    @Getter
    @AllArgsConstructor
    @EqualsAndHashCode
    @ToString
    public class ParentCategory {
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
