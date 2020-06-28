package com.querino.comandas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comandas")
public class ComandaController {
	

	@GetMapping()
	public String getComandas() {
		return "Retornando comandas";
	}
}
