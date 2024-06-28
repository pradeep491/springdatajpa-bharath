package com.test.springdatajpa.coupon.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Coupon {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String code;
    private BigDecimal discount;
    @Column(name="exp_date")
    private String expDate;
}
