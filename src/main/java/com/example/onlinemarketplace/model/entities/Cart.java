package com.example.onlinemarketplace.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart implements Serializable {
    @Id
    @GeneratedValue(generator = "Card_Gen", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "Cart_Gen", sequenceName = "Cart_Gen")
    @Column(name = "cart_id")
    private Long id;

    // Relationship
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
    private Set<CartProduct> cartProducts = new HashSet<>();
}
