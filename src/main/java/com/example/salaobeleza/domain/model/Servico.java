package com.example.salaobeleza.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Servico {

    private UUID id;
    private String nome;
    private String descricao;
    private BigDecimal valorServico;
    private Integer duracaoMinutos;

    public Servico() {
    }

    public Servico(UUID id, String nome, String descricao, BigDecimal valorServico, Integer duracaoMinutos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valorServico = valorServico;
        this.duracaoMinutos = duracaoMinutos;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorServico() {
        return valorServico;
    }

    public void setValorServico(BigDecimal valorServico) {
        this.valorServico = valorServico;
    }

    public Integer getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(Integer duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }
}
