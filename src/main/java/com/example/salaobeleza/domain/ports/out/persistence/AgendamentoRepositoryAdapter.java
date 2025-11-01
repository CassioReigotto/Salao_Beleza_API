package com.example.salaobeleza.domain.ports.out.persistence;

import com.example.salaobeleza.domain.model.Agendamento;
import com.example.salaobeleza.domain.ports.out.AgendamentoRepositoryPort;
import com.example.salaobeleza.infrastructure.mapper.AgendamentoMapper;
import com.example.salaobeleza.infrastructure.repository.jpa.AgendamentoJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AgendamentoRepositoryAdapter implements AgendamentoRepositoryPort {

    private final AgendamentoJpaRepository agendamentoJpaRepository;
    private final AgendamentoMapper agendamentoMapper;

    public AgendamentoRepositoryAdapter(AgendamentoJpaRepository agendamentoJpaRepository, AgendamentoMapper agendamentoMapper) {
        this.agendamentoJpaRepository = agendamentoJpaRepository;
        this.agendamentoMapper = agendamentoMapper;
    }


    @Override
    public Agendamento salvar(Agendamento agendamento) {
        var entity = agendamentoMapper.agendamentoDomainToAgendamentoEntity(agendamento);
        var agendamentoJpa = agendamentoJpaRepository.save(entity);
        return agendamentoMapper.agendamentoEntityToAgendamentoDomain(agendamentoJpa);
    }

    @Override
    public Optional<Agendamento> buscarPorId(UUID id) {
        return agendamentoJpaRepository.findById(id)
                .map(agendamentoMapper::agendamentoEntityToAgendamentoDomain);
    }

    @Override
    public List<Agendamento> buscarTodos() {
        return agendamentoJpaRepository.findAll()
                .stream()
                .map(agendamentoMapper::agendamentoEntityToAgendamentoDomain)
                .toList();
    }

    @Override
    public Agendamento atualizar(Agendamento agendamento) {
        if (!agendamentoJpaRepository.existsById(agendamento.getId())) {
            throw new EntityNotFoundException("O Id: " + agendamento.getId() + "nao existe no banco de dados.");
        }

        var entity = agendamentoMapper.agendamentoDomainToAgendamentoEntity(agendamento);
        var agendamentoJpa = agendamentoJpaRepository.save(entity);
        return agendamentoMapper.agendamentoEntityToAgendamentoDomain(agendamentoJpa);
    }

    @Override
    public void remover(UUID id) {
        agendamentoJpaRepository.deleteById(id);
    }
}
