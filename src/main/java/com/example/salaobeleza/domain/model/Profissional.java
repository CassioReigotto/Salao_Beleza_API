package com.example.salaobeleza.domain.model;

import com.example.salaobeleza.domain.model.enums.Especialidade;
import com.example.salaobeleza.domain.model.valueobject.Disponibilidade;
import com.example.salaobeleza.domain.model.valueobject.Email;

import java.util.UUID;

public class Profissional  {

    private UUID id;
    private String nome;
    private Email email;
    private String telefone;
    private Especialidade especialidade;
    private Disponibilidade disponibilidade;


    public Profissional(UUID id, String nome, Email email, String telefone, Especialidade especialidade, Disponibilidade disponibilidade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.disponibilidade = disponibilidade;
    }

    public Profissional() {

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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
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

}
