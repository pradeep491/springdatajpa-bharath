package com.test.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class CachingExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingExampleApplication.class, args);
	}

}
