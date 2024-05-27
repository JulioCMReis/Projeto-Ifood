package com.projetoifood.Projeto.Ifood.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Restaurante {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String endereco;
    private Integer precoMedio;
    @Column(precision=1, scale=1)
    private BigDecimal avaliacao;
    private Boolean temEntregador;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public Integer getPrecoMedio() {
        return precoMedio;
    }

    public BigDecimal getAvaliacao() {
        return avaliacao;
    }

    public Boolean getTemEntregador() {
        return temEntregador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setPrecoMedio(Integer precoMedio) {
        this.precoMedio = precoMedio;
    }

    public void setAvaliacao(BigDecimal avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setTemEntregador(Boolean temEntregador) {
        this.temEntregador = temEntregador;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
