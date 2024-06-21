package com.test.springdata.repo;

import com.test.springdata.entities.Customer;
import com.test.springdata.entities.CustomerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {
}
