package com.example.onlinemarketplace.model.repository;

import com.example.onlinemarketplace.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
