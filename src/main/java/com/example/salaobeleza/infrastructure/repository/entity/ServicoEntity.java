package com.example.salaobeleza.infrastructure.repository.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "Servicos")
public class ServicoEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false , length = 100)
    private String nome;
    @Column(length = 100)
    private String descricao;
    @Column(length = 100, nullable = false)
    private BigDecimal valorServico;
    @Column(length = 100, nullable = false)
    private Integer duracaoMinutos;

    protected ServicoEntity() {}

    public ServicoEntity(UUID id, String nome, String telefone, String descricao, BigDecimal valorServico, Integer duracaoMinutos) {
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
