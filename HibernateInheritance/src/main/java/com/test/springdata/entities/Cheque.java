package com.test.springdata.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("ch")
public class Cheque extends Payment{
    private String chequenumber;

}
