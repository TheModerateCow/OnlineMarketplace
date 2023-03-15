package com.example.onlinemarketplace.model.entities.OrderProduct;

import com.example.onlinemarketplace.model.entities.Order;
import com.example.onlinemarketplace.model.entities.Product;
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
public class OrderProduct {

    @Embeddable
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class OrderProductId implements Serializable {
        @Column(name = "order_id")
        private Long orderId;

        @Column(name = "product_id")
        private Long productId;

        public OrderProductId(Long orderId, Long productId) {
            super();
            this.orderId = orderId;
            this.productId = productId;
        }
    }

    @EmbeddedId
    private OrderProductId id = new OrderProductId();

    // Fields
    @Getter
    @Setter
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    public OrderProduct(Integer count, Order order, Product product) {
        super();
        this.count = count;
        this.order = order;
        this.product = product;

        // Link the entity/record objects to this entity
        this.id.orderId = order.getId();
        this.id.productId = product.getId();

        // Create a bidirectional relationship
        order.getOrderProducts().add(this);
        product.getOrderProducts().add(this);
    }
}
