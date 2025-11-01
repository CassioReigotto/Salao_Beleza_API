package com.example.salaobeleza.domain.ports.usecase;

import com.example.salaobeleza.domain.model.Profissional;
import com.example.salaobeleza.domain.ports.in.Profissional.ProfissionalUseCase;
import com.example.salaobeleza.domain.ports.out.ProfissionalRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ProfissionalUseCaseImpl implements ProfissionalUseCase {

    private final ProfissionalRepositoryPort profissionalRepositoryPort;

    public ProfissionalUseCaseImpl(ProfissionalRepositoryPort profissionalRepositoryPort) {
        this.profissionalRepositoryPort = profissionalRepositoryPort;
    }

    @Override
    public Profissional criar(Profissional profissional) {
        return profissionalRepositoryPort.salvar(profissional);
    }

    @Override
    public Optional<Profissional> buscarPorId(UUID id) {
        return profissionalRepositoryPort.buscarPorId(id);
    }

    @Override
    public List<Profissional> buscarTodos() {
        return profissionalRepositoryPort.buscarTodos();
    }

    @Override
    public Profissional atualizar(Profissional profissional) {
        Optional<Profissional> existente = buscarPorId(profissional.getId());
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("Profissional nao encontrado");
        }
        return profissionalRepositoryPort.atualizar(profissional);
    }

    @Override
    public void deletarPorId(UUID id) {
        profissionalRepositoryPort.remover(id);

    }
}
