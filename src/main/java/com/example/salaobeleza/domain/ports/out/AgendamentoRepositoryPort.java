package com.example.salaobeleza.domain.ports.out;

import com.example.salaobeleza.domain.model.Agendamento;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface AgendamentoRepositoryPort {

    Agendamento salvar(Agendamento agendamento);
    Agendamento findById(UUID id);

}
