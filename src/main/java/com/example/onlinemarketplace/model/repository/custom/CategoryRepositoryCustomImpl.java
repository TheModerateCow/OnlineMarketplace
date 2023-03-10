package com.example.onlinemarketplace.model.repository.custom;

import com.example.onlinemarketplace.model.dtos.CategoryDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CategoryDto> findAllCategoryDtos() {
        Map<Long, CategoryDto> categoryDtoMap = new LinkedHashMap<>();
        // ToDo
//        String query = """
//                SELECT
//                    c.id AS category_id,
//                    c.name AS category_name,
//                    c.description AS category_description,
//                    c.lastModifiedAt AS last_modified_at,
//                    c.parentCategory AS category
//                """
        return null;
    }
}
