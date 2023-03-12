package com.example.onlinemarketplace.model.repository.custom;

import com.example.onlinemarketplace.model.dtos.CategoryDto;
import jakarta.persistence.Tuple;

import java.util.List;

public interface CategoryRepositoryCustom {
    List<CategoryDto> findAllCategoryDtos();
}
