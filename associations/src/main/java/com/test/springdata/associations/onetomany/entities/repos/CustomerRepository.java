package com.test.springdata.associations.onetomany.entities.repos;

import com.test.springdata.associations.onetomany.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

}
