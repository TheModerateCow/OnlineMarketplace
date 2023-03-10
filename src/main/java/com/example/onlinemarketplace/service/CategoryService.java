package com.example.onlinemarketplace.service;

import com.example.onlinemarketplace.model.entities.Category;
import com.example.onlinemarketplace.model.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Provides a list of category objects that only has the necessary fields.
     * Oppose to getCategories() method, will return a complete list of categories,
     * including Items objects, timestamps and etc...
     *
     * @return a List of summarised category objects, if any (or an empty list)
     */
    public List<Category> getSummarisedCategories() {
        return categoryRepository.findAll();
    }

    /**
     * Provides a complete list of categories with all its field.
     *
     * @return a List of category objects, if any (or an empty list)
     */
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
