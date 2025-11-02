package com.example.salaobeleza.infrastructure.mapper;

import com.example.salaobeleza.domain.model.Agendamento;
import com.example.salaobeleza.domain.model.valueobject.Cpf;
import com.example.salaobeleza.domain.model.valueobject.Email;
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

    default Email map(String value) {
        return new Email(value);
    }

    default String map(Email email) {
        return email != null ? email.getEndereco() : null;
    }

    default Cpf mapCpf(String value) {
        return new Cpf(value);
    }

    default String mapCpf(Cpf cpf) {
        return cpf != null ? cpf.getNumero() : null;
    }
}
