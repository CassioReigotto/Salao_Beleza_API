package com.example.salaobeleza.domain.ports.usecase;

import com.example.salaobeleza.domain.model.Cliente;
import com.example.salaobeleza.domain.ports.in.Cliente.ClienteUseCase;
import com.example.salaobeleza.domain.ports.out.ClienteRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteUseCaseImpl implements ClienteUseCase {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public ClienteUseCaseImpl(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Cliente criar(Cliente cliente) {
        return clienteRepositoryPort.salvar(cliente);
    }

    @Override
    public Optional<Cliente> buscarPorId(UUID id) {
        return clienteRepositoryPort.buscarPorId(id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepositoryPort.buscarTodos();
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        Optional<Cliente> existente = clienteRepositoryPort.buscarPorId(cliente.getId());
        if(existente.isEmpty()){
            throw new IllegalArgumentException("Cliente nao encontrado");
        }
        return clienteRepositoryPort.atualizar(cliente);
    }

    @Override
    public void deletarPorId(UUID id) {
        clienteRepositoryPort.remover(id);
    }
}
