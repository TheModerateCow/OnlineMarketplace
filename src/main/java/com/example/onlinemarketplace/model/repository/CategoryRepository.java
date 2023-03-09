package com.example.onlinemarketplace.model.repository;

import com.example.onlinemarketplace.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
