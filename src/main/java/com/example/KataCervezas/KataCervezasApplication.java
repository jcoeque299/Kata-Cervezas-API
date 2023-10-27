package com.example.KataCervezas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.KataCervezas.*")
@ComponentScan(basePackages = { "com.example.KataCervezas.*" })
@EntityScan("com.example.KataCervezas.*")
public class KataCervezasApplication {
	public static void main(String[] args) {
		SpringApplication.run(KataCervezasApplication.class, args);
	}

}
