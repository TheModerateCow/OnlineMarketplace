package com.example.onlinemarketplace.model.repository;

import com.example.onlinemarketplace.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
