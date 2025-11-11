package com.example.salaobeleza.application.mapper;

import com.example.salaobeleza.application.dto.request.ProfissionalRequestDTO;
import com.example.salaobeleza.application.dto.response.ProfissionalResponseDTO;
import com.example.salaobeleza.domain.model.Profissional;
import com.example.salaobeleza.domain.model.valueobject.Cpf;
import com.example.salaobeleza.domain.model.valueobject.Email;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Mapper(componentModel = "spring")
public interface ProfissionalDTOMapper {

    Profissional profissionalRequestDTOToProfissionalDomain(ProfissionalRequestDTO dto);

    @Mapping(target = "diaSemana", expression = "java(profissional.getDiaSemana())")
    @Mapping(target = "horarioInicio", expression = "java(profissional.getHorarioInicio())")
    @Mapping(target = "horarioFim", expression = "java(profissional.getHorarioFim())")
    ProfissionalResponseDTO profissionalDomainToResponseDTO(Profissional profissional);



    // ======= HELPERS =======

    default DayOfWeek toDayOfWeek(Integer value) {
        return value != null ? DayOfWeek.of(value) : null;
    }

    default LocalTime toLocalTime(String value) {
        return value != null ? LocalTime.parse(value) : null;
    }


    // Email
    default Email map(String value) {
        return new Email(value);
    }

    default String map(Email email) {
        return email != null ? email.getEndereco() : null;
    }

    // CPF
    default Cpf mapCpf(String value) {
        return new Cpf(value);
    }

    default String mapCpf(Cpf cpf) {
        return cpf != null ? cpf.getNumero() : null;
    }

}
