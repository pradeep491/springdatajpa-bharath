package com.test.springdata.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
//@DiscriminatorValue(value = "cc")
@DiscriminatorValue("cc")
public class CreditCard extends Payment{
    private String cardnumber;
}
