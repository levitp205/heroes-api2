package com.digitalinnovationone.heroesapi2;



import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDynamoDBRepositories
@SpringBootApplication
public class Heroesapi2Application {

	public static void main(String[] args) {
		SpringApplication.run(Heroesapi2Application.class, args);
		System.out.println("Super poderes com webflux");
	}

}
