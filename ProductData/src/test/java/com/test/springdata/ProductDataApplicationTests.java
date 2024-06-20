package com.test.springdata;

import com.test.springdata.entity.Product;
import com.test.springdata.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProductDataApplicationTests {

    @Autowired
    private ProductRepository repo;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreate() {
        Product p = new Product();
        p.setId(1);
        p.setName("IPhone");
        p.setDesc("Awesome");
        p.setPrice(10000.0d);
        repo.save(p);
    }

    @Test
    public void testRead() {
        Product p = repo.findById(1).get();
        assertNotNull(p);
        assertEquals("IPhone", p.getName());
        System.out.println(">>>>>>>>>>>>>>>>>" + p);
    }

    @Test
    public void testUpdate() {
        Product p = repo.findById(1).get();
        p.setPrice(11000.0d);
        repo.save(p);
    }

    @Test
    public void testDelete() {
        Product p = repo.findById(1).get();
        //repo.deleteById(1); //(or)
        //repo.deleteById(p.getId());//(or)
        repo.delete(p);
    }

    @Test
    public void testDelete1() {
        if (repo.existsById(1)) {
            repo.deleteById(1);
        }
    }
    @Test
    public void testCount() {
        System.out.println("Total Records-"+repo.count());
    }
}
