package br.com.jornada.produto;

import br.com.jornada.produto.domain.Produto;
import br.com.jornada.produto.domain.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(ProdutoRepository repository){
		return (args -> {
			repository.save(new Produto(1L, "Livro", 47.0));
			repository.save(new Produto(2L, "Curso", 52.0));
		});
	}
}
