package com.querino.disponibilidade.entregadores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disponibilidade-entregadores")
public class DisponibilidadeEntregadoresController {
	

	@GetMapping()
	public String getDisponibilidadeEntregadores() {
		return "Retornando Disponibilidade de Entregadores";
	}
}
