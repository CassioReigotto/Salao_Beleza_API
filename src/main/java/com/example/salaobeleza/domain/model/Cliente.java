package com.example.salaobeleza.domain.model;


import com.example.salaobeleza.domain.model.valueobject.Cpf;
import com.example.salaobeleza.domain.model.valueobject.Email;

import java.util.UUID;

public class Cliente {

    private UUID id;
    private String nome;
    private  final  Cpf cpf;
    private final Email email;
    private String telefone;


    public Cliente(UUID id, String nome, Cpf cpf, Email email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
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


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
