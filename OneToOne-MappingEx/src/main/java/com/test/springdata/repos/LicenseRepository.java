package com.test.springdata.repos;

import com.test.springdata.entities.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends JpaRepository<License,Long> {
}
