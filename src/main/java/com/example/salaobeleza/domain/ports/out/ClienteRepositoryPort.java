package com.example.salaobeleza.domain.ports.out;

import com.example.salaobeleza.domain.model.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ClienteRepositoryPort {

    Cliente salvar(Cliente cliente);
    Optional<Cliente> buscarPorId(UUID id);
    List<Cliente> buscarTodos();
    Cliente atualizar(Cliente cliente);
    void remover(UUID id);

}
