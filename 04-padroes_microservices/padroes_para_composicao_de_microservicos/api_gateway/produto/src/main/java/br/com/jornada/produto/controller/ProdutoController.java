package br.com.jornada.produto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
    @GetMapping("/produto")
    public String hello(){
        return "Hello Produto";
    }
}
