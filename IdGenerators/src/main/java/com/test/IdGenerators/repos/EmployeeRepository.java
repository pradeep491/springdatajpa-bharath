package com.test.IdGenerators.repos;

import com.test.IdGenerators.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

}
