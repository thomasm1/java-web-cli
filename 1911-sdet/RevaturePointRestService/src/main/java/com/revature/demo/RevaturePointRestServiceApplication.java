package com.revature.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.revature.repositories")
@ComponentScan("com.revature")
@EntityScan("com.revature.entities")
public class RevaturePointRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevaturePointRestServiceApplication.class, args);
	}

}
