package com.test.springdata;

import com.test.springdata.entity.Product;
import com.test.springdata.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ProductDataPagingAndSortingApplicationTests {
    @Autowired
    private ProductRepository repo;

    @Test
    void contextLoads() {
    }

    @Test
    public void testFindAll() {
        Pageable pageable = PageRequest.of(2, 2);
        Page<Product> page = repo.findAll(pageable);
        page.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void testFindAllSorting() {
        Sort sortOrder = Sort.by(Sort.Direction.DESC, "name");
        repo.findAll(sortOrder).forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void testFindAllMultiSorting() {

        String sortBy = "name";
        String sortByPrice = "price";
        String sortDir = "desc";
        String priceSortDir = "asc";

        Sort sortByName = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Sort sortByPrice1 = priceSortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortByPrice).ascending() : Sort.by(sortByPrice).descending();


        Sort groupBySort = sortByName.and(sortByPrice1);
        repo.findAll(groupBySort).forEach(p -> System.out.println(p.getName()));
        System.out.println("==================================");
        Sort sortOrder = Sort.by(Sort.Direction.DESC, "name", "price");
        repo.findAll(sortOrder).forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void testFindAllMultiSortingDirection() {
        repo.findAll(Sort.by(Sort.Order.desc("name"),
                Sort.Order.asc("price")));
    }

    @Test
    public void testFindAllPagingAndSorting() {
        Pageable pageable = PageRequest.of(0,2, Sort.by("name").descending());
        repo.findAll(pageable).forEach(p-> System.out.println(p.getName()));
    }
    @Test
    public void testFindByIdIn() {
        Pageable pageable = PageRequest.of(1, 2);
        List<Product> list = repo.findByIdIn(Arrays.asList(1,2,3,4),pageable);
        list.forEach(p->System.out.println(p.getName()));
    }
}
