package com.test.springdata.associations;

import com.test.springdata.associations.onetomany.entities.Customer;
import com.test.springdata.associations.onetomany.entities.PhoneNumber;
import com.test.springdata.associations.onetomany.entities.repos.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;
import java.util.Set;

@SpringBootTest
class AssociationsBetterWayOfForeignKeyApplicationTests {

    @Autowired
    private CustomerRepository repo;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setName("test");

        PhoneNumber ph1 = new PhoneNumber();
        ph1.setNumber("1234567890");
        ph1.setType("cell");

        PhoneNumber ph2 = new PhoneNumber();
        ph2.setNumber("0987654321");
        ph2.setType("home");

        customer.addPhoneNUmber(ph1);
        customer.addPhoneNUmber(ph2);

        repo.save(customer);
    }

    @Test
    @Transactional//this will load the child object when we requested without throwing the exception
    public void testLoadCustomer() {
        Customer customer = repo.findById(6L).get();
        System.out.println(customer.getName());
        Set<PhoneNumber> numbers = customer.getNumbers();
        numbers.forEach(number-> System.out.println(number.getNumber()));
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = repo.findById(6L).get();
        customer.setName("pradeep kumar");
        System.out.println(customer.getName());
        Set<PhoneNumber> numbers = customer.getNumbers();
        numbers.forEach(number-> number.setType("cell"));
        repo.save(customer);
    }

    @Test
    public void testDelete(){
        repo.deleteById(8L);
    }
}
