package com.silva.imc.service;

import com.silva.imc.entity.HistoricoImcEntity;
import com.silva.imc.repository.CalculadoraImcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Calculador de IMC - Indece de massa corporal
 * https://www.fetalmed.net/calculadoras/calculadora-de-indice-de-massa-corporal-imc-e-peso-ideal/
 */
@Service
public class CalculadoraImcService {

    @Autowired
    private CalculadoraImcRepository repository;

    public Double calcularImc(final Double peso, final Double altura) {
        return BigDecimal.valueOf(peso / (altura * altura)).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    public SituacaoPeso avaliarPeso(final double peso, final double altura) {

        SituacaoPeso situacao = null;
        final double imc = calcularImc(peso, altura);
        if (imc < 18.5) {
            situacao = SituacaoPeso.ABAIXO;
        } else if (imc >= 18.5 && imc <= 24.9) {
            situacao = SituacaoPeso.IDEAL;
        } else if (imc >= 25.0 && imc <= 30.0) {
            situacao = SituacaoPeso.SOBREPESO;
        } else if (imc >= 30.1 && imc <= 39.9) {
            situacao = SituacaoPeso.OBESO;
        } else if (imc >= 40) {
            situacao = SituacaoPeso.OBESO_MORBIDO;
        }
//        HistoricoImcEntity historico = new HistoricoImcEntity(peso, altura, situacao);
//
//        repository.save(historico);

        return situacao;
    }
}
