package com.test.springdata.entities.tableperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="bankcheck")
public class Cheque extends Payment {
    private String checknumber;

}
