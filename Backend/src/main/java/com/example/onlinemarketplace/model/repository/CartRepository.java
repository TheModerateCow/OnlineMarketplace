package com.example.onlinemarketplace.model.repository;

import com.example.onlinemarketplace.model.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
