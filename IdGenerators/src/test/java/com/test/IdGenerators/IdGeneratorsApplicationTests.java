package com.test.IdGenerators;

import com.test.IdGenerators.entity.Employee;
import com.test.IdGenerators.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdGeneratorsApplicationTests {
    @Autowired
    private EmployeeRepository repo;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateEmployee() {
        Employee e = new Employee();
        //e.setId(123L);
        e.setName("punarvika");
        repo.save(e);
    }
}
