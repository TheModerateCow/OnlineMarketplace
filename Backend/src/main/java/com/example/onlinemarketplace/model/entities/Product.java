package com.example.onlinemarketplace.model.entities;

import com.example.onlinemarketplace.model.entities.OrderProduct.OrderProduct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product implements Serializable {
    @Id
    @GeneratedValue(generator = "Product_Gen", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "Product_Gen", sequenceName = "Product_Gen")
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_price")
    private BigDecimal price;

    @Column(name = "product_description")
    private String description;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<OrderProduct> orderProducts = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<CartProduct> cartProducts = new HashSet<>();

    // Timestamps
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime lastModifiedAt;
}
