package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@EntityScan(basePackages = "com.curso.model")
@EnableJpaRepositories(basePackages = "com.curso.dao")
@SpringBootApplication(scanBasePackages = {"com.curso.controller", "com.curso.service","com.curso.inicio"})
public class Ejercicio5CursoCrudConfigCesarApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio5CursoCrudConfigCesarApplication.class, args);
	}

	@Bean
	public RestTemplate template() {
		BasicAuthenticationInterceptor intercep;
		intercep = new BasicAuthenticationInterceptor("admin", "admin");
		RestTemplate template=new RestTemplate();
		template.getInterceptors().add(intercep);
		return template;
	}
}
