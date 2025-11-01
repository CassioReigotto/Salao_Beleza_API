package com.example.salaobeleza.domain.ports.usecase;

import com.example.salaobeleza.domain.model.Servico;
import com.example.salaobeleza.domain.ports.in.Servico.ServicoUseCase;
import com.example.salaobeleza.domain.ports.out.ServicoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServicoUseCaseImpl implements ServicoUseCase {

    private final ServicoRepositoryPort servicoRepositoryPort;

    public ServicoUseCaseImpl(ServicoRepositoryPort servicoRepositoryPort) {
        this.servicoRepositoryPort = servicoRepositoryPort;
    }


    @Override
    public Servico criar(Servico servico) {
        return servicoRepositoryPort.salvar(servico);
    }

    @Override
    public Optional<Servico> buscarPorId(UUID id) {
        return servicoRepositoryPort.findById(id);
    }

    @Override
    public List<Servico> buscarTodos() {
        return servicoRepositoryPort.buscarTodos();
    }

    @Override
    public Servico atualizar(Servico servico) {
        Optional<Servico> existente = buscarPorId(servico.getId());
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("Servico nao encontrado");
        }
        return servicoRepositoryPort.atualizar(servico);
    }

    @Override
    public void deletar(UUID id) {
        servicoRepositoryPort.remover(id);
    }
}
