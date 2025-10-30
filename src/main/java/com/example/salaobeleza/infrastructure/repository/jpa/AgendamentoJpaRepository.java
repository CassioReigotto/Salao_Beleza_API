package com.example.salaobeleza.infrastructure.repository.jpa;

import com.example.salaobeleza.domain.model.Agendamento;
import com.example.salaobeleza.infrastructure.repository.entity.AgendamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgendamentoJpaRepository extends JpaRepository<AgendamentoEntity, UUID> {
}
