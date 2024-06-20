package com.test.springdata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class Product {
    @Id
    private int id;
    private String name;
    @Column(name="description")
    private String desc;
    private Double price;
}
