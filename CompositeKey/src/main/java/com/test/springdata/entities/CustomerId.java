package com.test.springdata.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerId implements Serializable {
    private int id;
    private String email;
}
