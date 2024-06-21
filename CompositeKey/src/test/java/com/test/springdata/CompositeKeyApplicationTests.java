package com.test.springdata;

import com.test.springdata.entities.Customer;
import com.test.springdata.repo.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompositeKeyApplicationTests {

    @Autowired
    private CustomerRepository repo;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer();
        customer.setId(1234);
        customer.setEmail("k.pradeep0491@gmail.com");
        customer.setName("test");
        repo.save(customer);
    }
}
