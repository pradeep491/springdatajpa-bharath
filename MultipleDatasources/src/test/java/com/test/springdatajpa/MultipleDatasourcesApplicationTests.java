package com.test.springdatajpa;

import com.test.springdatajpa.coupon.entities.Coupon;
import com.test.springdatajpa.coupon.repos.CouponRepository;
import com.test.springdatajpa.product.entities.Product;
import com.test.springdatajpa.product.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.*;

@SpringBootTest
class MultipleDatasourcesApplicationTests {
    @Autowired
    private CouponRepository repo;

    @Autowired
    private ProductRepository repo1;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCouponSave() {
        Coupon coupon = new Coupon();
        coupon.setCode("SUPERSALE");
        coupon.setDiscount(BigDecimal.valueOf(20));
        coupon.setExpDate("12/12/2022");
        System.out.println(repo.save(coupon));

    }

    @Test
    public void testProductSave() {
        Product product = new Product();
        product.setName("TV");
        product.setDescription("Awesome");
        product.setPrice(BigDecimal.valueOf(1000));
        product.setCouponCode("SUPERSALE");
        System.out.println(repo1.save(product));

    }
}
