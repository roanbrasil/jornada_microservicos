package br.com.jornada;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/carros", 
    consumes="application/json", 
    produces = "application/json")
public class CarroController {

    @PostMapping
    public void adicionarCarro(@RequestBody AdicionarCarro adicionarCarro) {
        
    }

    @GetMapping
    public List<Carro> buscarCarros() {
        return null;
    }

    @PutMapping("{id}")
    public void atualizarCarro(@PathVariable(name = "id") Integer id, AtualizarCarro atualizarCarro) {

    }

    @DeleteMapping("{id}")
    public void apagarCarro(@PathVariable(name = "id")  Integer id) {
        
    }
}