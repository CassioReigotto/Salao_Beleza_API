package com.example.salaobeleza.domain.ports.out;

import com.example.salaobeleza.domain.model.Servico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ServicoRepositoryPort {

    Servico findById(UUID id);
    Optional<Servico> findByNome(String nome);
    List<Servico> findAll();
    Servico atualizar(Servico servico);
    void remover(UUID id);

}
