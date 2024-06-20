package com.test.springdata;

import com.test.springdata.entity.Product;
import com.test.springdata.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ProductDataFinderMethodsApplicationTests {

    @Autowired
    private ProductRepository repo;

    @Test
    void contextLoads() {
    }

    @Test
    public void testFindByName() {
        List<Product> list = repo.findByName("TV");
        list.forEach(p->System.out.println(p.getPrice()));
    }
    @Test
    public void testFindByNameAndDesc() {
        List<Product> list = repo.findByNameAndDesc("TV","Samsung");
        list.forEach(p->System.out.println(p.getPrice()));
    }
    @Test
    public void testFindByPriceGreaterThan() {
        List<Product> list = repo.findByPriceGreaterThan(1000.0d);
        list.forEach(p->System.out.println(p.getName()));
    }
    @Test
    public void testFindByDescriptionContaines() {
        List<Product> list = repo.findByDescContains("Awesome");
        list.forEach(p->System.out.println(p.getName()));
    }
    @Test
    public void testFindByPriceBetween() {
        List<Product> list = repo.findByPriceBetween(10000d,20000d);
        list.forEach(p->System.out.println(p.getName()));
    }
    @Test
    public void testFindByDescLike() {
        List<Product> list = repo.findByDescLike("%we%");
        list.forEach(p->System.out.println(p.getName()));
    }
    @Test
    public void testFindByIdIn() {
        List<Product> list = repo.findByIdIn(Arrays.asList(1,3,4));
        list.forEach(p->System.out.println(p.getName()));
    }
}
