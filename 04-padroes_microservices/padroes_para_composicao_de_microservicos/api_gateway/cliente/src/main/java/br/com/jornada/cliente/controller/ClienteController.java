package br.com.jornada.cliente.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    @GetMapping("/cliente")
    public String hello(){
        return "Hello Cliente";
    }
}
