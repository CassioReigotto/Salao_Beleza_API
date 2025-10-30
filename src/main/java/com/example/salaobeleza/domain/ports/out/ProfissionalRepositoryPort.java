package com.example.salaobeleza.domain.ports.out;

import com.example.salaobeleza.domain.model.Profissional;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface ProfissionalRepositoryPort {

    Profissional salvar(Profissional profissional);
    Profissional findById(UUID id);

}
