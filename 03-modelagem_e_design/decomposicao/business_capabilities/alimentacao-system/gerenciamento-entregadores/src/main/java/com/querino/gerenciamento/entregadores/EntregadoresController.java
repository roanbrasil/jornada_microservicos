package com.querino.gerenciamento.entregadores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entregadores")
public class EntregadoresController {
	

	@GetMapping()
	public String getEntregadores() {
		return "Retornando Entregadores";
	}
}
