package com.test.springdata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;

@Entity
@Data
@Table
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Product implements Serializable {
    @Id
    private int id;
    private String name;
    @Column(name="description")
    private String desc;
    private Double price;
}
