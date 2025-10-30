package com.example.salaobeleza.domain.ports.out;

import com.example.salaobeleza.domain.model.Servico;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface ServicoRepositoryPort {

    Servico findById(UUID id);
    Servico cadastrar(Servico servico);

}
