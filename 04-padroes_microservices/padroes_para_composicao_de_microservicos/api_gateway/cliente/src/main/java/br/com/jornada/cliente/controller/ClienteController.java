import org.springframework.web.bind.annotation.RestController;
package br.com.jornada.cliente.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    @GetMapping("/cliente")
    public String hello(){
        return "Hello Cliente";
    }

    @GetMapping("/cliente/{id}")
    public String helloById(@PathVariable Long id){
        return "Hello Cliente com ID: " + id;
    }
}
