package com.example.salaobeleza.application.mapper;


import com.example.salaobeleza.application.dto.request.AgendamentoRequestDTO;
import com.example.salaobeleza.application.dto.response.AgendamentoResponseDTO;
import com.example.salaobeleza.domain.model.Agendamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = { ClienteIdMapper.class, ServicoIdMapper.class, ProfissionalIdMapper.class }
)
public interface AgendamentoDTOMapper {

    @Mapping(source = "clienteId", target = "cliente")
    @Mapping(source = "servicoId", target = "servico")
    @Mapping(source = "profissionalId", target = "profissional")
    Agendamento agendamentoRequestDTOToAgendamentoDomain (AgendamentoRequestDTO dto);

    @Mapping(source = "cliente.id", target = "clienteId")
    @Mapping(source = "servico.id", target = "servicoId")
    @Mapping(source = "profissional.id", target = "profissionalId")
    AgendamentoResponseDTO agendamentoDomainToAgendamentoResponseDTO (Agendamento agendamento);



}
