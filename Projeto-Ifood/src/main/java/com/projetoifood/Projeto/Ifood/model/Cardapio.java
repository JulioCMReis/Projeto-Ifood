package com.projetoifood.Projeto.Ifood.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Cardapio {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nomeDoPrato;
    @Column(precision=12, scale=2)
    private BigDecimal valor;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    public Integer getId() {
        return id;
    }

    public String getNomeDoPrato() {
        return nomeDoPrato;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }
}
