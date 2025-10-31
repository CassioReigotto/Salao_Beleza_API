package com.example.salaobeleza.domain.ports.in.Agendamento;

import com.example.salaobeleza.domain.model.Agendamento;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AgendamentoUseCase {

    Agendamento criar(Agendamento agendamento);
    Optional<Agendamento> buscarPorId(UUID id);
    List<Agendamento> buscarTodos();
    Agendamento atualizar(Agendamento agendamento);
    void deletar(UUID id);



}
