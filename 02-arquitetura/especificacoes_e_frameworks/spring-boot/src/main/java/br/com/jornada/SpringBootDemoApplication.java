package br.com.jornada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

	
@SpringBootApplication
@RestController
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@GetMapping("/exemplo")
    public String exemplo(@RequestParam(value = "name", defaultValue = "Exemplo") String name) {
       return String.format("Meu primeiro %s!", name);
    }
}
