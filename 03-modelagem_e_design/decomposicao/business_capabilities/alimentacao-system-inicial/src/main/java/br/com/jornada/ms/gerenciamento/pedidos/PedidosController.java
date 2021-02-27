package br.com.jornada.ms.gerenciamento.pedidos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {
	

	@GetMapping()
	public String getPedidos() {
		return "Retornando pedidos";
	}
}
