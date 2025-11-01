package com.example.salaobeleza.domain.ports.out;

import com.example.salaobeleza.domain.model.Servico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ServicoRepositoryPort {

    Servico salvar(Servico servico);
    Optional<Servico> findById(UUID id);
    List<Servico> buscarTodos();
    Servico atualizar(Servico servico);
    void remover(UUID id);

}
