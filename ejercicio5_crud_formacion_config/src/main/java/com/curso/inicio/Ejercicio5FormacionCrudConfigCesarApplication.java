package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EntityScan(basePackages = "com.curso.model")
@SpringBootApplication(scanBasePackages = {"com.curso.controller", "com.curso.service","com.curso.inicio"})
public class Ejercicio5FormacionCrudConfigCesarApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio5FormacionCrudConfigCesarApplication.class, args);
	}

	@LoadBalanced
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
}
