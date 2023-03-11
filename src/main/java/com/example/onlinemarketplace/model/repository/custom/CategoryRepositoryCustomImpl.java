package com.example.onlinemarketplace.model.repository.custom;

import com.example.onlinemarketplace.model.dtos.CategoryDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

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
//                    c.parentCategory AS parent_category_id,
//                    pc.name AS parent_category_name,
//                    c.description AS parent_description,
//                    p.id AS product_id,
//                    p.name AS product_name
//                FROM
//                    Category c
//                JOIN
//                    Product p
//                        ON p.id = c.id
//                JOIN
//                    Category pc
//                        ON pc.id = p.id
//                """;
//        List<Tuple> resultStream = em.createQuery(query, Tuple.class).getResultList();


        return null;
    }
}
