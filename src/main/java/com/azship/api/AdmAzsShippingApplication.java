package com.azship.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AdmAzsShippingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmAzsShippingApplication.class, args);
	}

}
