package com.example.salaobeleza.application.mapper;


import com.example.salaobeleza.application.dto.request.ServicoRequestDTO;
import com.example.salaobeleza.application.dto.response.ServicoResponseDTO;
import com.example.salaobeleza.domain.model.Servico;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ServicoDTOMapper {

    Servico servicoRequestDTOToServicoDomain (ServicoRequestDTO dto);

    ServicoResponseDTO servicoDomainToServicoResponseDTO (Servico servico);


}
