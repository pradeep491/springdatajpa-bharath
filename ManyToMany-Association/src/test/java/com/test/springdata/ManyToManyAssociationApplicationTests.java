package com.test.springdata;

import com.test.springdata.entities.Programmer;
import com.test.springdata.entities.Project;
import com.test.springdata.repos.ProgrammerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
class ManyToManyAssociationApplicationTests {

    @Autowired
    private ProgrammerRepository repo;

    @Test
    void contextLoads() {
    }

    @Test
    public void testM2MCreateProgrammer() {

        Programmer programmer = new Programmer();
        programmer.setName("kumar");
        programmer.setSalary(20000);

        Set<Project> projects = new HashSet<>();
        Project p = new Project();
        p.setName("Microservices");
        projects.add(p);

        programmer.setProjects(projects);
        repo.save(programmer);
    }

    @Test
    //@Transactional
    public void testFindByM2M() {
        Programmer programmer = repo.findById(1).get();
        System.out.println(programmer);
        System.out.println(programmer.getProjects());
    }
}
