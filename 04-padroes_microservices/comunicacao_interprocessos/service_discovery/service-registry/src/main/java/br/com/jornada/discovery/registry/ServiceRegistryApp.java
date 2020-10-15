package br.com.jornada.discovery.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceRegistryApp {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryApp.class, args);
	}

}
