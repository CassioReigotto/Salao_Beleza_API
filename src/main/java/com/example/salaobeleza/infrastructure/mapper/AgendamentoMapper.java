package com.example.salaobeleza.infrastructure.mapper;

import com.example.salaobeleza.domain.model.Agendamento;
import com.example.salaobeleza.infrastructure.repository.entity.AgendamentoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring")
public interface AgendamentoMapper {

    @Mapping(source = "statusAgendamento" , target = "status")
     AgendamentoEntity agendamentoDomainToAgendamentoEntity(Agendamento agendamento);


    @InheritInverseConfiguration
     Agendamento agendamentoEntityToAgendamentoDomain(AgendamentoEntity agendamentoEntity);
}
