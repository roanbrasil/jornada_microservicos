package br.com.jornada.cliente;

import br.com.jornada.cliente.domain.Cliente;
import br.com.jornada.cliente.domain.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(ClienteRepository repository){
		return (args -> {
			repository.save(new Cliente(1L, "Dorival", 47));
			repository.save(new Cliente(2L, "Tom Hanks", 52));
		});
	}
}
