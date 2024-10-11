package com.elianisded.ecommercecapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="order_id", nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    private Product product;
    private Integer quantity;
    private BigDecimal price;
}
