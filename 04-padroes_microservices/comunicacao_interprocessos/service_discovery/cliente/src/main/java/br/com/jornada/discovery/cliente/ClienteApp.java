package br.com.jornada.discovery.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class ClienteApp {

	public static void main(String[] args) {
		SpringApplication.run(ClienteApp.class, args);
	}

}

@RestController
class DescobertaDeServicos {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/servico/{nome}")
	public List<ServiceInstance> instanciasDeServicoPeloNome(
			@PathVariable String nome) {
		return this.discoveryClient.getInstances(nome);
	}
}

