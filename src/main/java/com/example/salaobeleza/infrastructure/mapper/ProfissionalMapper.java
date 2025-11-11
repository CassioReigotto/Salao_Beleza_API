package com.example.salaobeleza.infrastructure.mapper;


import com.example.salaobeleza.domain.model.Profissional;
import com.example.salaobeleza.infrastructure.repository.entity.ProfissionalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.DayOfWeek;


@Mapper(componentModel = "spring")
public interface ProfissionalMapper {

    @Mapping(source = "email.endereco" , target = "email")
    @Mapping(source = "especialidade", target = "especialidade", defaultValue = "SEM_ESPECIALIDADE")
    ProfissionalEntity ProfissionalDomainToProfissionalToEntity(Profissional profissional);

    @Mapping(target = "email", expression = "java(new com.example.salaobeleza.domain.model.valueobject.Email(profissionalEntity.getEmail()))")
    Profissional ProfissionalEntityToProfissionalDomain(ProfissionalEntity profissionalEntity);

    default DayOfWeek map(Integer value) {
        return value != null ? DayOfWeek.of(value) : null;
    }

    default Integer map(DayOfWeek value) {
        return value != null ? value.getValue() : null;
    }


}

