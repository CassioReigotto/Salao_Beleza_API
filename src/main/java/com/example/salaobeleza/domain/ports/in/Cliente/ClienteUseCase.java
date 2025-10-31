package com.example.salaobeleza.domain.ports.in.Cliente;

import com.example.salaobeleza.domain.model.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteUseCase {

    Cliente criar(Cliente cliente);
    Optional<Cliente> buscarPorId(UUID id);
    List<Cliente> buscarTodos();
    Cliente atualizar(Cliente cliente);
    void deletarPorId(UUID id);

}
