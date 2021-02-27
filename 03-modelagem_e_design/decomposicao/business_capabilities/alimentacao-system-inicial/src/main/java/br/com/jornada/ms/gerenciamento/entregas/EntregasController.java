package br.com.jornada.ms.gerenciamento.entregas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entregas")
public class EntregasController {
	

	@GetMapping()
	public String getEntregas() {
		return "Retornando Entregas";
	}
}
