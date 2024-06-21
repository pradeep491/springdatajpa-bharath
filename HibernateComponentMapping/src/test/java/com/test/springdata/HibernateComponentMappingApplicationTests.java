package com.test.springdata;

import com.test.springdata.entities.Address;
import com.test.springdata.entities.Employee;
import com.test.springdata.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HibernateComponentMappingApplicationTests {
    @Autowired
    private EmployeeRepository repo;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreate() {
        Address add = new Address();
        add.setCity("NANDYALA");
        add.setCountry("India");
        add.setState("Andhara Pradesh");
        add.setStreetaddress("Main Road");
        add.setZipcode("518166");

        Employee e = new Employee();
        e.setId(1);
        e.setName("pradeep");
        e.setAddress(add);

        repo.save(e);
    }

}
