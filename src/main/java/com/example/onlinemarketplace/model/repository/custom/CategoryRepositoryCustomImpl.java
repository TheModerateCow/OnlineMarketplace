package com.example.onlinemarketplace.model.repository.custom;

import com.example.onlinemarketplace.model.dtos.CategoryDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

@Transactional
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    // ToDo Add pagination to this
    @Override
    public List<CategoryDto> findAllCategoryDtos() {
        Map<Long, CategoryDto> categoryDtoMap = new LinkedHashMap<>();

        String query = """
                SELECT
                    c.id AS category_id,
                    c.name AS category_name,
                    c.description AS category_description,
                    c.lastModifiedAt AS last_modified_at,
                    c.createdAt AS created_at,
                    pc.id AS parent_category_id,
                    pc.name AS parent_category_name,
                    p.id AS product_id,
                    p.name AS product_name
                FROM
                    Category c
                LEFT JOIN
                    c.parentCategory pc
                LEFT JOIN
                    c.products p
                """;
        List<CategoryDto> resultStream = em.createQuery(query, Tuple.class).getResultStream().map(tuple -> {
            CategoryDto categoryDto = categoryDtoMap.computeIfAbsent(tuple.get("category_id", Long.class), a ->
            new CategoryDto(tuple.get("category_id", Long.class), tuple.get("category_name", String.class), tuple.get("category_description", String.class), tuple.get("last_modified_at", LocalDateTime.class), tuple.get("created_at", LocalDateTime.class)));

            // Add ParentCategory into CategoryDto
            categoryDto.addParentCategory(tuple.get("parent_category_id", Long.class), tuple.get("parent_category_name", String.class));

            // Add Products into CategoryDto
            categoryDto.getProducts().add(new CategoryDto.Product(tuple.get("product_id", Long.class), tuple.get("product_name", String.class)));

            return categoryDto;
        }).distinct().toList();


        return resultStream;
    }
}
