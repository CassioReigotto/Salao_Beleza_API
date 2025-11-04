package com.example.salaobeleza.infrastructure.mapper;


import com.example.salaobeleza.domain.model.Profissional;
import com.example.salaobeleza.infrastructure.repository.entity.ProfissionalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ProfissionalMapper {

    @Mapping(source = "email.endereco" , target = "email")
    @Mapping(source = "especialidade", target = "especialidade", defaultValue = "SEM_ESPECIALIDADE")
    @Mapping(source = "disponibilidade.diaSemana", target = "diaSemana")
    @Mapping(source = "disponibilidade.horarioInicio", target = "horarioInicio")
    @Mapping(source = "disponibilidade.horarioFim", target = "horarioFim")
    ProfissionalEntity ProfissionalDomainToProfissionalToEntity(Profissional profissional);

    @Mapping(target = "email", expression = "java(new com.example.salaobeleza.domain.model.valueobject.Email(profissionalEntity.getEmail()))")
    @Mapping(target = "disponibilidade", expression = "java(new com.example.salaobeleza.domain.model.valueobject.Disponibilidade(" +
            "profissionalEntity.getDiaSemana(), " +
            "profissionalEntity.getHorarioInicio(), " +
            "profissionalEntity.getHorarioFim()))")
    Profissional ProfissionalEntityToProfissionalDomain(ProfissionalEntity profissionalEntity);


}

