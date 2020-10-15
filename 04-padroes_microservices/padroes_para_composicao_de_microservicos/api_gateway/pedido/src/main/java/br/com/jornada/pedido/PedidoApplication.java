package br.com.jornada.pedido;

import br.com.jornada.pedido.domain.Pedido;
import br.com.jornada.pedido.domain.PedidoRepository;
import br.com.jornada.pedido.domain.Produto;
import br.com.jornada.pedido.domain.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PedidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidoApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadData(PedidoRepository repository,
									  ProdutoRepository produtoRepository){
		return (args -> {
			Produto produto = new Produto(1L);
			produtoRepository.save(produto);
			List<Produto> list = new ArrayList<>();
			list.add(produto);
			//list.add(new Produto(2L));
			repository.save(new Pedido(1L, 1L, list ));
		});
	}
}
