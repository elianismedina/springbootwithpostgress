package com.elianisded.ecommercecapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.elianisded.ecommercecapp.model")
@EnableJpaRepositories(basePackages = "com.elianisded.ecommercecapp.repositories")


public class EcommercecappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommercecappApplication.class, args);
	}

}
