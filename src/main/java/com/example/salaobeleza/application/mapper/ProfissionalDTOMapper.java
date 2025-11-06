package com.example.salaobeleza.application.mapper;


import com.example.salaobeleza.application.dto.request.ProfissionalRequestDTO;
import com.example.salaobeleza.application.dto.response.ProfissionalResponseDTO;
import com.example.salaobeleza.domain.model.Profissional;
import com.example.salaobeleza.domain.model.valueobject.Cpf;
import com.example.salaobeleza.domain.model.valueobject.Email;
import org.mapstruct.Mapper;


@Mapper (componentModel = "spring")
public interface ProfissionalDTOMapper {


    Profissional profissionalRequestDTOToProfissionalDomain (ProfissionalRequestDTO dto);

    ProfissionalResponseDTO profissionalDomainToResponseDTO (Profissional profissional);

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
