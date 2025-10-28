package com.example.salaobeleza.infrastructure.repository.entity;

import com.example.salaobeleza.domain.model.enums.Especialidade;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Profissionais")
public class ProfissionalEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, length = 254)
    private String nome;

    @Column(nullable = false, length = 254)
    private String email;

    @Column(unique = false,length = 15)
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Column(nullable = false, length = 50)
    private String disponibilidade;

    protected ProfissionalEntity() {}

    public ProfissionalEntity(UUID id, String nome, String email, String telefone, Especialidade especialidade, String disponibilidade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.disponibilidade = disponibilidade;
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

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
