package com.example.salaobeleza.infrastructure.repository.entity;

import com.example.salaobeleza.domain.model.enums.Especialidade;
import com.example.salaobeleza.domain.model.valueobject.Email;
import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "profissionais")
public class ProfissionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    private String email;

    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "dia_semana")
    private DayOfWeek diaSemana;


    @Column(name = "horario_inicio", nullable = false)
    private LocalTime horarioInicio;

    @Column(name = "horario_fim", nullable = false)
    private LocalTime horarioFim;

    public ProfissionalEntity() {}

    public ProfissionalEntity(UUID id, String nome, String email, String telefone, Especialidade especialidade, DayOfWeek diaSemana, LocalTime horarioInicio, LocalTime horarioFim) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.diaSemana = diaSemana;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }

    public ProfissionalEntity(UUID id, String nome, String telefone, Email email, Especialidade especialidade, LocalTime horarioInicio, LocalTime horarioFim, DayOfWeek diaSemana) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email.getEndereco();
        this.especialidade = especialidade;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.diaSemana = diaSemana;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public DayOfWeek getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DayOfWeek diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
    }
}
