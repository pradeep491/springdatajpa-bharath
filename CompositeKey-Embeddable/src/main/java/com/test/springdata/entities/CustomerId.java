package com.test.springdata.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class CustomerId implements Serializable {
    private int id;
    private String email;
}
