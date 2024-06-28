package com.test.springdatajpa.coupon.repos;

import com.test.springdatajpa.coupon.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Long> {
}
