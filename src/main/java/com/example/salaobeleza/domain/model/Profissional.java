package com.example.salaobeleza.domain.model;

import com.example.salaobeleza.domain.model.enums.Especialidade;
import com.example.salaobeleza.domain.model.valueobject.Email;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

public class Profissional  {

    private UUID id;
    private String nome;
    private Email email;
    private String telefone;
    private Especialidade especialidade;

    private DayOfWeek diaSemana;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;

    public Profissional(UUID id, String nome, Email email, String telefone,
                        Especialidade especialidade,
                        DayOfWeek diaSemana,
                        LocalTime horarioInicio,
                        LocalTime horarioFim) {

        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.diaSemana = diaSemana;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }

    public Profissional() {}

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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
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
