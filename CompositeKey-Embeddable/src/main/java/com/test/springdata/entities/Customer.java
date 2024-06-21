package com.test.springdata.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "customer1")
public class Customer {
    @EmbeddedId
    private CustomerId id;
    private String name;

}
