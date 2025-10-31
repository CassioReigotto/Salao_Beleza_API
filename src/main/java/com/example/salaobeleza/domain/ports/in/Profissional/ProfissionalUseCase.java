package com.example.salaobeleza.domain.ports.in.Profissional;

import com.example.salaobeleza.domain.model.Profissional;

import java.util.List;
import java.util.UUID;

public interface ProfissionalUseCase {

    Profissional criar(Profissional profissional);
    Profissional buscarPorId(UUID id);
    List<Profissional> buscarTodos();
    Profissional atualizar(Profissional profissional);
    void deletarPorId(UUID id);

}
