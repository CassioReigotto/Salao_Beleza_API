package com.example.salaobeleza.domain.ports.usecase;

import com.example.salaobeleza.domain.model.Agendamento;
import com.example.salaobeleza.domain.ports.in.Agendamento.AgendamentoUseCase;
import com.example.salaobeleza.domain.ports.out.AgendamentoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AgendamentoUseCaseImpl implements AgendamentoUseCase {

    private final AgendamentoRepositoryPort agendamentoRepositoryPort;

    public AgendamentoUseCaseImpl(AgendamentoRepositoryPort agendamentoRepositoryPort) {
        this.agendamentoRepositoryPort = agendamentoRepositoryPort;
    }

    @Override
    public Agendamento criar(Agendamento agendamento) {

        return agendamentoRepositoryPort.salvar(agendamento);
    }

    @Override
    public Optional<Agendamento> buscarPorId(UUID id) {
        return agendamentoRepositoryPort.buscarPorId(id);
    }

    @Override
    public List<Agendamento> buscarTodos() {
        return agendamentoRepositoryPort.buscarTodos();
    }

    @Override
    public Agendamento atualizar(Agendamento agendamento) {
        Optional<Agendamento> existente = agendamentoRepositoryPort.buscarPorId(agendamento.getId());
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("Agendamento nao encontrado");
        }
        return agendamentoRepositoryPort.atualizar(agendamento);
    }

    @Override
    public void deletar(UUID id) {
        agendamentoRepositoryPort.remover(id);
    }
}
