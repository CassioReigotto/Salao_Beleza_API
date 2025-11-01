package com.example.salaobeleza.infrastructure.mapper;

import com.example.salaobeleza.domain.model.Profissional;
import com.example.salaobeleza.infrastructure.repository.entity.ProfissionalEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring")
public interface ProfissionalMapper {

    @Mapping(source = "email.endereco" , target = "email")
    @Mapping(source = "especialidade", target = "especialidade", defaultValue = "SEM_ESPECIALIDADE")
    @Mapping(source = "disponibilidade.diaSemana", target = "diaSemana")
    @Mapping(source = "disponibilidade.horarioInicio", target = "horarioInicio")
    @Mapping(source = "disponibilidade.horarioFim", target = "horarioFim")
     ProfissionalEntity ProfissionalDomainToProfissionalToEntity(Profissional profissional);

    @InheritInverseConfiguration
     Profissional ProfissionalEntityToProfissionalDomain(ProfissionalEntity profissionalEntity);


}
