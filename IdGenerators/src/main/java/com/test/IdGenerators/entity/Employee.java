package com.test.IdGenerators.entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Employee {
    //@TableGenerator(name="employee_gen",table = "id_gen",pkColumnName = "gen_name",valueColumnName = "gen_val",allocationSize = 100)
    @Id
    //@GeneratedValue(strategy = GenerationType.TABLE,generator = "employee_gen")
    @GenericGenerator(name = "emp_id", strategy = "com.test.IdGenerators.CustomRandomIdGenerator")
    @GeneratedValue(generator = "emp_id")
    private Long id;
    private String name;
}
