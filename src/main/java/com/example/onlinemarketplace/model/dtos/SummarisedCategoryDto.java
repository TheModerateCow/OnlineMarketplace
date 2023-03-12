package com.example.onlinemarketplace.model.dtos;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SummarisedCategoryDto {
    private Long id;

    private String category_name;

    private String category_description;

    private LocalDateTime last_modified_at;

    private LocalDateTime created_at;
}
