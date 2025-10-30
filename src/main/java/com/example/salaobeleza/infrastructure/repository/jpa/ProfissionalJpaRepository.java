package com.example.salaobeleza.infrastructure.repository.jpa;

import com.example.salaobeleza.domain.model.Profissional;
import com.example.salaobeleza.infrastructure.repository.entity.ProfissionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfissionalJpaRepository extends JpaRepository<ProfissionalEntity, UUID> {
}
