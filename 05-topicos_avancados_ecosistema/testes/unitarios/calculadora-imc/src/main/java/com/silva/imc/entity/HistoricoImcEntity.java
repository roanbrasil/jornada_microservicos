package com.silva.imc.entity;

import com.silva.imc.service.SituacaoPeso;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class HistoricoImcEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    private Date data;

    private Double peso;

    private Double altura;

    private SituacaoPeso situacao;

    public HistoricoImcEntity(){}
    public HistoricoImcEntity(double peso, double altura, SituacaoPeso situacao) {
        this.situacao = situacao;
        this.altura = altura;
        this.peso = peso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public SituacaoPeso getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoPeso situacao) {
        this.situacao = situacao;
    }
}
