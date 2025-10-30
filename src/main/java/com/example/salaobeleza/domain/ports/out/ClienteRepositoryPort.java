package com.example.salaobeleza.domain.ports.out;

import com.example.salaobeleza.domain.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface ClienteRepositoryPort {

    Cliente salvar(Cliente cliente);
    Cliente findById(UUID id);

}
