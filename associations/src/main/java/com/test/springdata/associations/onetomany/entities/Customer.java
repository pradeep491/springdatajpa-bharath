package com.test.springdata.associations.onetomany.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

//@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy="customer",cascade = CascadeType.ALL)
    private Set<PhoneNumber> numbers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PhoneNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(Set<PhoneNumber> numbers) {
        this.numbers = numbers;
    }
    /*public void addPhoneNUmber(PhoneNumber number){
        if(number != null){
            if(numbers == null){
                numbers = new HashSet<>();
            }
            number.setCustomer(this);
            numbers.add(number);

        }
    }*/
}
