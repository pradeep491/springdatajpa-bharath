package com.test.springdata.repos;

import com.test.springdata.entities.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammerRepository extends JpaRepository<Programmer,Integer> {
}
