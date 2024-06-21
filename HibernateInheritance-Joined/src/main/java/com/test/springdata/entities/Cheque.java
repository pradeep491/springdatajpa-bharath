package com.test.springdata.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="bankcheck")
@PrimaryKeyJoinColumn(name="id")
public class Cheque extends Payment {
    private String checknumber;

}
