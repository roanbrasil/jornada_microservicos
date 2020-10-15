package com.querino.restaurantes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dados-restaurantes")
public class DadosRestaurantesController {
	

	@GetMapping()
	public String getDadosRestaurantes() {
		return "Retornando Dados de Restaurantes";
	}
}
