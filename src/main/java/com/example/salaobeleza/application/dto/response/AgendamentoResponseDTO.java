package com.example.salaobeleza.application.dto.response;

import com.example.salaobeleza.domain.model.enums.StatusAgendamento;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoResponseDTO(
        @NotNull(message = "Data e hora são obrigatórias")
        LocalDateTime dataHora,

        @NotNull(message = "Status obrigatório")
        StatusAgendamento status,

        @NotNull(message = "Cliente é obrigatório")
        UUID clienteId,

        @NotNull(message = "Serviço é obrigatório")
        UUID servicoId,

        @NotNull(message = "Profissional é obrigatório")
        UUID profissionalId
) {}
