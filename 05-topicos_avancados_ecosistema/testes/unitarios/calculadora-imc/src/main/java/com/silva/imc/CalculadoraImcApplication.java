package com.silva.imc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CalculadoraImcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculadoraImcApplication.class, args);
	}

}
