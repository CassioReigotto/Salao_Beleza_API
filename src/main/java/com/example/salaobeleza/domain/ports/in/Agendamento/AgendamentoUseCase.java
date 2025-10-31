package com.example.salaobeleza.domain.ports.in.Agendamento;

import com.example.salaobeleza.domain.model.Agendamento;

import java.util.List;
import java.util.UUID;

public interface AgendamentoUseCase {

    Agendamento criar(Agendamento agendamento);
    Agendamento buscarPorId(UUID id);
    List<Agendamento> buscarTodos();
    Agendamento atualizar(Agendamento agendamento);
    void deletar(UUID id);



}
