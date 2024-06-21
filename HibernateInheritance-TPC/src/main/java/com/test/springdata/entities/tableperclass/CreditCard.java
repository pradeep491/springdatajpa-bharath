package com.test.springdata.entities.tableperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="card")
public class CreditCard extends Payment {
    private String cardnumber;
}
