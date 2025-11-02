package com.example.salaobeleza.application.mapper;


import com.example.salaobeleza.application.dto.request.AgendamentoRequestDTO;
import com.example.salaobeleza.application.dto.response.AgendamentoResponseDTO;
import com.example.salaobeleza.domain.model.Agendamento;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface AgendamentoDTOMapper {

    Agendamento agendamentoRequestDTOToAgendamentoDomain (AgendamentoRequestDTO dto);

    AgendamentoResponseDTO agendamentoDomainToAgendamentoResponseDTO (Agendamento agendamento);

}
