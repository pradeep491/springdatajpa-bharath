package com.test.springdata;

import com.test.springdata.entities.License;
import com.test.springdata.entities.Person;
import com.test.springdata.repos.LicenseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class OneToOneMappingExApplicationTests {

	@Autowired
	private LicenseRepository repo;
	@Test
	void contextLoads() {
	}

	@Test
	public void testOneToOneLicense(){

		License license = new License();
		license.setType("Car");
		license.setValidFrom(LocalDate.now());
		license.setValidTo(LocalDate.now().plusYears(10L));

		Person p = new Person();
		p.setFirstName("pradeep");
		p.setLastName("Kumar");
		p.setAge(33);
		license.setPerson(p);

		repo.save(license);
	}
}
