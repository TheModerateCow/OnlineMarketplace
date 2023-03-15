package com.example.onlinemarketplace.model.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.io.Serializable;

@Entity
@Immutable
@NoArgsConstructor
public class CartProduct {
    @Embeddable
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class Id implements Serializable {
        @Column(name = "cart_id")
        private Long cartId;

        @Column(name = "product_id")
        private Long productId;

        public Id(Long orderId, Long productId) {
            super();
            this.cartId = orderId;
            this.productId = productId;
        }
    }

    @EmbeddedId
    private Id id = new Id();

    // Fields
    @Getter
    @Setter
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "cart_id", insertable = false, updatable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    public CartProduct(Integer count, Cart cart, Product product) {
        super();
        this.count = count;
        this.cart = cart;
        this.product = product;

        // Link the entity/record objects to this entity
        this.id.cartId = cart.getId();
        this.id.productId = product.getId();

        // Create a bidirectional relationship
        cart.getCartProducts().add(this);
        product.getCartProducts().add(this);
    }
}
