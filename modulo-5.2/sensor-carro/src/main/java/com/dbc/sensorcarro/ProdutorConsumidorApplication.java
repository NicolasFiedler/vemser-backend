package com.dbc.sensorcarro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ProdutorConsumidorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutorConsumidorApplication.class, args);
	}

}
