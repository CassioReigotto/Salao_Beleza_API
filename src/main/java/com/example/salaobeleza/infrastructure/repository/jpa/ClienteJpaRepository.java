package com.example.salaobeleza.infrastructure.repository.jpa;

import com.example.salaobeleza.domain.model.Cliente;
import com.example.salaobeleza.infrastructure.repository.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, UUID> {
}
