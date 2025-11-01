package com.example.salaobeleza.domain.ports.out.persistence;

import com.example.salaobeleza.domain.model.Profissional;
import com.example.salaobeleza.domain.ports.out.ProfissionalRepositoryPort;
import com.example.salaobeleza.infrastructure.mapper.ProfissionalMapper;
import com.example.salaobeleza.infrastructure.repository.jpa.ProfissionalJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProfissionalRepositoryAdapter implements ProfissionalRepositoryPort {

    private final ProfissionalJpaRepository profissionalJpaRepository;
    private final ProfissionalMapper profissionalMapper;

    public ProfissionalRepositoryAdapter(ProfissionalJpaRepository profissionalJpaRepository, ProfissionalMapper profissionalMapper) {
        this.profissionalJpaRepository = profissionalJpaRepository;
        this.profissionalMapper = profissionalMapper;
    }


    @Override
    public Profissional salvar(Profissional profissional) {
        var entity = profissionalMapper.ProfissionalDomainToProfissionalToEntity(profissional);
        var jpaEntity = profissionalJpaRepository.save(entity);
        return profissionalMapper.ProfissionalEntityToProfissionalDomain(jpaEntity);
    }

    @Override
    public Optional<Profissional> buscarPorId(UUID id) {
        return profissionalJpaRepository.findById(id)
                .map(profissionalMapper::ProfissionalEntityToProfissionalDomain);
    }

    @Override
    public List<Profissional> buscarTodos() {
        return profissionalJpaRepository.findAll()
                .stream()
                .map(profissionalMapper::ProfissionalEntityToProfissionalDomain)
                .toList();
    }

    @Override
    public Profissional atualizar(Profissional profissional) {
        if (!profissionalJpaRepository.existsById(profissional.getId())) {
            throw new EntityNotFoundException("Cliente ID: " + profissional.getId() + "Nao encontrado");
        }
        var entity = profissionalMapper.ProfissionalDomainToProfissionalToEntity(profissional);
        var jpaEntity = profissionalJpaRepository.save(entity);
        return profissionalMapper.ProfissionalEntityToProfissionalDomain(jpaEntity);
        }


    @Override
    public void remover(UUID id) {
        profissionalJpaRepository.deleteById(id);
    }
}
