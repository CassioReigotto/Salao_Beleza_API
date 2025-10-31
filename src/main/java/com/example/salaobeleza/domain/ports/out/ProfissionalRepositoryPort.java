package com.example.salaobeleza.domain.ports.out;

import com.example.salaobeleza.domain.model.Profissional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ProfissionalRepositoryPort {

    Profissional salvar(Profissional profissional);
    Optional<Profissional> buscarPorId(UUID id);
    List<Profissional> buscarTodos();
    Profissional atualizar(Profissional profissional);
    void remover(UUID id);

}
