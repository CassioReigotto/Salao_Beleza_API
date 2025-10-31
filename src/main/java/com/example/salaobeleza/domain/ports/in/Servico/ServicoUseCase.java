package com.example.salaobeleza.domain.ports.in.Servico;

import com.example.salaobeleza.domain.model.Servico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServicoUseCase {

    Servico criar(Servico servico);
    Optional<Servico> buscarPorId(UUID id);
    List<Servico> buscarTodos();
    Servico atualizar(Servico servico);
    void deletar(UUID id);


}
