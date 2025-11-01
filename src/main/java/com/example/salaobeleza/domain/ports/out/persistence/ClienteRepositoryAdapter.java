package com.example.salaobeleza.domain.ports.out.persistence;

import com.example.salaobeleza.domain.model.Cliente;
import com.example.salaobeleza.domain.ports.out.ClienteRepositoryPort;
import com.example.salaobeleza.infrastructure.mapper.ClienteMapper;
import com.example.salaobeleza.infrastructure.repository.jpa.ClienteJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteJpaRepository  clienteJpaRepository;
    private final ClienteMapper clienteMapper;

    public ClienteRepositoryAdapter(ClienteJpaRepository clienteJpaRepository, ClienteMapper clienteMapper) {
        this.clienteJpaRepository = clienteJpaRepository;
        this.clienteMapper = clienteMapper;
    }



    @Override
    public Cliente salvar(Cliente cliente) {
        var entity = clienteMapper.clienteDomainToClienteEntity(cliente);
        var jpaEntity = clienteJpaRepository.save(entity);
        return clienteMapper.clienteEntityToClienteDomain(jpaEntity);
    }

    @Override
    public Optional<Cliente> buscarPorId(UUID id) {
        return clienteJpaRepository.findById(id)
                .map(clienteMapper::clienteEntityToClienteDomain);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteJpaRepository.findAll()
                .stream()
                .map(clienteMapper::clienteEntityToClienteDomain)
                .toList();
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        if (!clienteJpaRepository.existsById(cliente.getId())) {
            throw new EntityNotFoundException("Cliente ID: " + cliente.getId() + "Nao encontrado");
        }
        var entity = clienteMapper.clienteDomainToClienteEntity(cliente);
        var jpaEntity = clienteJpaRepository.save(entity);
        return clienteMapper.clienteEntityToClienteDomain(jpaEntity);
    }

    @Override
    public void remover(UUID id) {
        clienteJpaRepository.deleteById(id);
    }
}
