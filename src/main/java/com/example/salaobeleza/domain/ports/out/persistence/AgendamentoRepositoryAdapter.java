package com.example.salaobeleza.domain.ports.out.persistence;

import com.example.salaobeleza.domain.model.Agendamento;
import com.example.salaobeleza.domain.ports.out.AgendamentoRepositoryPort;
import com.example.salaobeleza.infrastructure.mapper.AgendamentoMapper;
import com.example.salaobeleza.infrastructure.repository.jpa.AgendamentoJpaRepository;
import com.example.salaobeleza.infrastructure.repository.jpa.ClienteJpaRepository;
import com.example.salaobeleza.infrastructure.repository.jpa.ProfissionalJpaRepository;
import com.example.salaobeleza.infrastructure.repository.jpa.ServicoJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AgendamentoRepositoryAdapter implements AgendamentoRepositoryPort {

    private final AgendamentoJpaRepository agendamentoJpaRepository;
    private final AgendamentoMapper agendamentoMapper;
    private final ClienteJpaRepository clienteJpaRepository;
    private final ServicoJpaRepository servicoJpaRepository;
    private final ProfissionalJpaRepository profissionalJpaRepository;

    public AgendamentoRepositoryAdapter(AgendamentoJpaRepository agendamentoJpaRepository, AgendamentoMapper agendamentoMapper, ClienteJpaRepository clienteJpaRepository, ServicoJpaRepository servicoJpaRepository, ProfissionalJpaRepository profissionalJpaRepository) {
        this.agendamentoJpaRepository = agendamentoJpaRepository;
        this.agendamentoMapper = agendamentoMapper;
        this.clienteJpaRepository = clienteJpaRepository;
        this.servicoJpaRepository = servicoJpaRepository;
        this.profissionalJpaRepository = profissionalJpaRepository;
    }


    @Override
    public Agendamento salvar(Agendamento agendamento) {

        var entity = agendamentoMapper.agendamentoDomainToAgendamentoEntity(agendamento);

        var cliente = clienteJpaRepository.findById(agendamento.getCliente().getId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        var servico = servicoJpaRepository.findById(agendamento.getServico().getId())
                .orElseThrow(() -> new EntityNotFoundException("Serviço não encontrado"));

        var profissional = profissionalJpaRepository.findById(agendamento.getProfissional().getId())
                .orElseThrow(() -> new EntityNotFoundException("Profissional não encontrado"));

        entity.setCliente(cliente);
        entity.setServico(servico);
        entity.setProfissional(profissional);

        var salvo = agendamentoJpaRepository.save(entity);

        return agendamentoMapper.agendamentoEntityToAgendamentoDomain(salvo);
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
