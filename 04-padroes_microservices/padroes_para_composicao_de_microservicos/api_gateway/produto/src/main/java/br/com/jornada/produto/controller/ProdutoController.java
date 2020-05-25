package br.com.jornada.produto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
    @GetMapping("/produto")
    public String hello(){
        return "Hello Produto";
    }

    @GetMapping("/produto/{id}")
    public String helloById(@PathVariable String id){
        return "Hello Produto com ID: " + id;
    }
}
