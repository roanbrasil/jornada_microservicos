package com.example.microservicebook;

import com.example.microservicebook.config.EnvironmentConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceBookApplication implements CommandLineRunner {

	@Autowired
    private EnvironmentConfig environmentConfig;
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBookApplication.class, args);
	}

	public void run(String... args) throws Exception {
        System.out.println(environmentConfig.getUrl());
    }

}
