package com.example.onlinemarketplace;

import com.example.onlinemarketplace.model.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartupRunner implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    public StartupRunner(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("------------Start------------");
//        System.out.println(categoryRepository.findAllCategoryDtos());
        System.out.println("------------End------------");

    }
}
