package com.example.onlinemarketplace.controller;

import com.example.onlinemarketplace.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "v1/api")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

//    @GetMapping(path = "")
//    public ResponseEntity<List<Category>> getAll
}
