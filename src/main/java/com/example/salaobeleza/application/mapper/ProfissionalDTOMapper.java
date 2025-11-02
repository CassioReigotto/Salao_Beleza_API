package com.example.salaobeleza.application.mapper;


import com.example.salaobeleza.application.dto.request.ProfissionalRequestDTO;
import com.example.salaobeleza.application.dto.response.ProfissionalResponseDTO;
import com.example.salaobeleza.domain.model.Profissional;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ProfissionalDTOMapper {

    Profissional profissionalRequestDTOToProfissionalDomain (ProfissionalRequestDTO dto);

    ProfissionalResponseDTO profissionalDomainToResponseDTO (Profissional profissional);

}
