package com.example.onlinemarketplace.model.dtos;

import com.example.onlinemarketplace.model.entities.Category;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SummarisedCategoryDto {
    private String name;

    private String description;
}
