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
    private Long category_id;

    private String category_name;

    private String category_description;

    private LocalDateTime last_modified_at;

    private LocalDateTime created_at;

    private ParentCategory parent_category;

    private List<Product> products = new ArrayList<>();

    public CategoryDto(Long id, String name, String description, LocalDateTime lastModifiedAt, LocalDateTime createdAt) {
        this.category_id = id;
        this.category_name = name;
        this.category_description = description;
        this.last_modified_at = lastModifiedAt;
        this.created_at = createdAt;
    }

    public void addParentCategory(Long id, String name){
        this.parent_category = new ParentCategory(id, name);
    }

    @Getter
    @AllArgsConstructor
    @EqualsAndHashCode
    @ToString
    public class ParentCategory {
        private Long parent_category_id;

        private String parent_category_name;
    }

    @Getter
    @AllArgsConstructor
    @EqualsAndHashCode
    @ToString
    public static class Product {
        private Long product_id;

        private String product_name;

    }
}
