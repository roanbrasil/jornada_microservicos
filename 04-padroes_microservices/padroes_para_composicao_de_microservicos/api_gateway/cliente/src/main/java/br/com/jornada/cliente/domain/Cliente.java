package br.com.jornada.cliente.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
    public Cliente() {
    }

    @Id
    private Long id;
    private String nome;
    private Integer idade;

    public Cliente(Long id, String nome, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
