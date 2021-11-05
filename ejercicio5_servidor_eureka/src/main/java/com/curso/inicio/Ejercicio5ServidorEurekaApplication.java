package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Ejercicio5ServidorEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio5ServidorEurekaApplication.class, args);
	}

}
