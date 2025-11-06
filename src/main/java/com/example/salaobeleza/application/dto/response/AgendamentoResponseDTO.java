package com.example.salaobeleza.application.dto.response;

import com.example.salaobeleza.domain.model.enums.StatusAgendamento;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoResponseDTO(

        UUID id,

        LocalDateTime dataHora,

        StatusAgendamento status,

        UUID clienteId,

        UUID servicoId,

        UUID profissionalId
) {}
