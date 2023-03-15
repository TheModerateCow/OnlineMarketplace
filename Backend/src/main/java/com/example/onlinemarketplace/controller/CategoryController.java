package com.example.onlinemarketplace.controller;

import com.example.onlinemarketplace.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "v1/api", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/categories")
    public ResponseEntity<List<?>> getAllSummarisedCategories(@RequestParam(defaultValue = "true") Boolean summarise) {
        return new ResponseEntity<>(categoryService.getCategories(summarise), HttpStatus.OK);
    }
}
