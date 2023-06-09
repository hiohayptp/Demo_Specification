package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.example.demo.repository")
@SpringBootApplication
public class DemoSpecification {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpecification.class, args);
	}

}
