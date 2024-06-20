package com.test.springdata.associations;

import com.test.springdata.associations.onetomany.entities.Customer;
import com.test.springdata.associations.onetomany.entities.PhoneNumber;
import com.test.springdata.associations.onetomany.entities.repos.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class AssociationsApplicationTests {

    @Autowired
    private CustomerRepository repo;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setName("pradeep");
        Set<PhoneNumber> numbers = new HashSet<>();

        PhoneNumber ph1 = new PhoneNumber();
        ph1.setNumber("1234567890");
        ph1.setType("cell");
        ph1.setCustomer(customer);
        numbers.add(ph1);

        PhoneNumber ph2 = new PhoneNumber();
        ph2.setNumber("0987654321");
        ph2.setType("home");
        ph2.setCustomer(customer);
        numbers.add(ph2);

        customer.setNumbers(numbers);
        repo.save(customer);
    }
}
