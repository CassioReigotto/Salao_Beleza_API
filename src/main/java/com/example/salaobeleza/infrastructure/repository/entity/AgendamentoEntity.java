package com.example.salaobeleza.infrastructure.repository.entity;
import com.example.salaobeleza.domain.model.enums.StatusAgendamento;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Agendamentos")
public class AgendamentoEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private StatusAgendamento status;

    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    private ServicoEntity servico;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProfissionalEntity profissional;

    protected AgendamentoEntity() {}

    public AgendamentoEntity(UUID id, LocalDateTime dataHora, StatusAgendamento status, ClienteEntity cliente, ServicoEntity servico, ProfissionalEntity profissional) {
        this.id = id;
        this.dataHora = dataHora;
        this.status = status;
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

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public ServicoEntity getServico() {
        return servico;
    }

    public void setServico(ServicoEntity servico) {
        this.servico = servico;
    }

    public ProfissionalEntity getProfissional() {
        return profissional;
    }

    public void setProfissional(ProfissionalEntity profissional) {
        this.profissional = profissional;
    }
}
