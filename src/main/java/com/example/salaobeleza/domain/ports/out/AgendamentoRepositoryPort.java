package com.example.salaobeleza.domain.ports.out;

import com.example.salaobeleza.domain.model.Agendamento;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface AgendamentoRepositoryPort {

    Agendamento salvar(Agendamento agendamento);
    Optional <Agendamento> buscarPorId(UUID id);
    List<Agendamento> buscarTodos();
    Agendamento atualizar(Agendamento agendamento);
    void remover(UUID id);

}
