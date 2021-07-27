package com.silva.imc.controller;

import com.silva.imc.service.CalculadoraImcService;
import com.silva.imc.service.SituacaoPeso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.http.ResponseEntity.ok;

@Controller
public class CalculadoraImcController {

    @Autowired
    private CalculadoraImcService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SituacaoPeso> calcularImc(Double peso, Double altura){
        return new ResponseEntity<SituacaoPeso>(service.avaliarPeso(peso, altura), HttpStatus.ACCEPTED);
    }

}
