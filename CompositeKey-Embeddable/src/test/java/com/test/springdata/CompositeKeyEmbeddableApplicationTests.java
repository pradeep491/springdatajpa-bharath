package com.test.springdata;

import com.test.springdata.entities.Customer;
import com.test.springdata.entities.CustomerId;
import com.test.springdata.repo.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CompositeKeyEmbeddableApplicationTests {

    @Autowired
    private CustomerRepository repo;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSaveCustomer() {
        CustomerId cid = new CustomerId();
        cid.setId(4321);
        cid.setEmail("pradeep0491@outlook.com");

        Customer customer = new Customer();
        customer.setName("test1");
        customer.setId(cid);
        repo.save(customer);
    }

    @Test
    public void getEmails() {
        List<Object[]> list = repo.getEmails();
        for (Object obj[] : list) {
            System.out.println(obj[0]);
        }
    }

}
