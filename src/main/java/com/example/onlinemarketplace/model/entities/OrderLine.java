package com.example.onlinemarketplace.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OrderLine {
    @Id
    private Long id;
}
