package com.proyecto.yankiClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class YankiClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(YankiClientApplication.class, args);
	}

}
