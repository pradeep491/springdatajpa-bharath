package com.test.springdatajpa.product.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String name;
    private BigDecimal price;
    @Transient
    private String couponCode;
}
