package com.test.springdata.repos;

import com.test.springdata.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByName(String name);
    List<Product> findByNameAndDesc(String name,String desc);
    List<Product> findByPriceGreaterThan(double price);
    List<Product> findByDescContains(String desc);
    List<Product> findByPriceBetween(double price1,double price2);

    List<Product> findByDescLike(String desc);

    List<Product> findByIdIn(List<Integer> ids);
}
