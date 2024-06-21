package com.test.springdata.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@IdClass(CustomerId.class)
@Table(name="customer1")
public class Customer {
    @Id
    private int id;
    @Id
    private String email;
    private String name;

}
