package com.example.onlinemarketplace.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;

public class Cart implements Serializable {
    @Id
    @GeneratedValue(generator = "Card_Gen", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "Cart_Gen", sequenceName = "Cart_Gen")
    @Column(name = "cart_id")
    private Long id;
}
