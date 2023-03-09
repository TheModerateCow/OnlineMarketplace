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
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"Order\"") // Note that Order alr taken, use "Order" name instead
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order implements Serializable {
    @Id
    @GeneratedValue(generator = "Order_Gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Order_Gen", sequenceName = "Order_Gen")
    @Column(name = "order_id")
    private Long id;

    // Relationships
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "order")
    private Set<OrderProduct> orderProducts = new HashSet<>();

    // Timestamp
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime lastModifiedAt;
}
