package com.example.onlinemarketplace.model.repository;

import com.example.onlinemarketplace.model.dtos.SummarisedCategoryDto;
import com.example.onlinemarketplace.model.entities.Category;
import com.example.onlinemarketplace.model.repository.custom.CategoryRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryRepositoryCustom {
    /**
     * Query a summarised Category object using JPQL.
     *
     * @see SummarisedCategoryDto
     * @return a List of SummarisedCategoryDto
     */
    @Query("SELECT new com.example.onlinemarketplace.model.dtos.SummarisedCategoryDto(c.name, c.description, c.parentCategory) FROM Category c")
    List<SummarisedCategoryDto> findAllSummarisedCategoryDtos();
}
