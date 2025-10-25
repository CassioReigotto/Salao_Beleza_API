package com.example.salaobeleza.domain.model;

import com.example.salaobeleza.domain.model.enums.StatusAgendamento;

import java.time.LocalDateTime;
import java.util.UUID;

public class Agendamento{

    private UUID id;
    private LocalDateTime dataHora;
    private StatusAgendamento statusAgendamento;
    private Cliente cliente;
    private Servico servico;
    private Profissional profissional;

    public Agendamento(UUID id, LocalDateTime dataHora, StatusAgendamento statusAgendamento, Cliente cliente, Servico servico, Profissional profissional) {
        this.id = id;
        this.dataHora = dataHora;
        this.statusAgendamento = statusAgendamento;
        this.cliente = cliente;
        this.servico = servico;
        this.profissional = profissional;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }
}
