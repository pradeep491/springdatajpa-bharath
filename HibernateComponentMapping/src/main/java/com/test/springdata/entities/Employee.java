package com.test.springdata.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee2")
public class Employee {
    @Id
    private int id;
    private String name;
    @Embedded
    private Address address;

}
