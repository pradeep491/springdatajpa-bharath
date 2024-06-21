package com.test.springdata.repo;

import com.test.springdata.entities.Customer;
import com.test.springdata.entities.CustomerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {

    @Query("select c.id.email from Customer c")
    List<Object[]> getEmails();
}
