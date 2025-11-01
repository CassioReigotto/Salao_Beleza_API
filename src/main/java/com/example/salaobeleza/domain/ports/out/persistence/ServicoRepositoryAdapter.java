package com.example.salaobeleza.domain.ports.out.persistence;

import com.example.salaobeleza.domain.model.Servico;
import com.example.salaobeleza.domain.ports.out.ServicoRepositoryPort;
import com.example.salaobeleza.infrastructure.mapper.ServicoMapper;
import com.example.salaobeleza.infrastructure.repository.jpa.ServicoJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ServicoRepositoryAdapter implements ServicoRepositoryPort {

    private final ServicoJpaRepository servicoJpaRepository;
    private final ServicoMapper servicoMapper;

    public ServicoRepositoryAdapter(ServicoJpaRepository servicoJpaRepository, ServicoMapper servicoMapper) {
        this.servicoJpaRepository = servicoJpaRepository;
        this.servicoMapper = servicoMapper;
    }


    @Override
    public Servico salvar(Servico servico) {
        var entity = servicoMapper.servicoDomaintoToServicoEntity(servico);
        var jpaEntity = servicoJpaRepository.save(entity);
        return servicoMapper.servicoEntityToServicoDomain(jpaEntity);
    }

    @Override
    public Optional<Servico> findById(UUID id) {
        return servicoJpaRepository.findById(id)
                .map(servicoMapper::servicoEntityToServicoDomain);
    }



    @Override
    public List<Servico> buscarTodos() {
        return servicoJpaRepository.findAll()
                .stream()
                .map(servicoMapper::servicoEntityToServicoDomain)
                .toList();
    }

    @Override
    public Servico atualizar(Servico servico) {
        if (!servicoJpaRepository.existsById(servico.getId())) {
            throw new EntityNotFoundException("Cliente ID: " + servico.getId() + "Nao encontrado");
        }
        var entity = servicoMapper.servicoDomaintoToServicoEntity(servico);
        var jpaEntity = servicoJpaRepository.save(entity);
        return servicoMapper.servicoEntityToServicoDomain(jpaEntity);
    }


    @Override
    public void remover(UUID id) {
        servicoJpaRepository.deleteById(id);

    }
}
