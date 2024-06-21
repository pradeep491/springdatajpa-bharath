package com.test.springdata.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Embeddable
public class Address {

    private String streetaddress;
    private String city;
    private String state;
    private String zipcode;
    private String country;
}
