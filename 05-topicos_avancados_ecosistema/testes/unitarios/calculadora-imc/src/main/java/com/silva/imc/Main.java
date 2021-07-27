package com.silva.imc;

import com.silva.imc.service.CalculadoraImcService;
import com.silva.imc.service.SituacaoPeso;

public class Main {

    public static void main(String[] args) {
        double peso = 70.0, altura = 1.68;
        SituacaoPeso situacaoPeso =  new CalculadoraImcService().avaliarPeso(peso, altura);
        if (situacaoPeso == SituacaoPeso.IDEAL) {
            System.out.println("Teste passou!");
        }else {
            System.out.println("Teste falhou!");
        }
    }
}
