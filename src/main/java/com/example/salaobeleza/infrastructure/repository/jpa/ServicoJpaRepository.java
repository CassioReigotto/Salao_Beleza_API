package com.example.salaobeleza.infrastructure.repository.jpa;

import com.example.salaobeleza.domain.model.Servico;
import com.example.salaobeleza.infrastructure.repository.entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServicoJpaRepository extends JpaRepository<ServicoEntity, UUID> {
}
