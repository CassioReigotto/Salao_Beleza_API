package com.example.salaobeleza.infrastructure.mapper;

import com.example.salaobeleza.domain.model.Agendamento;
import com.example.salaobeleza.infrastructure.repository.entity.AgendamentoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring")
public interface AgendamentoMapper {

    @Mapping(source = "statusAgendamento" , target = "status")
    public AgendamentoEntity agendamentoToAgendamentoEntity(Agendamento agendamento);


    @InheritInverseConfiguration
    public Agendamento agendamentoEntityToAgendamentoDomain(AgendamentoEntity agendamentoEntity);
}
