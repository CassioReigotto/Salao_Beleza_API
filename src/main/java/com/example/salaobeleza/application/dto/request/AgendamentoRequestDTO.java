package com.example.salaobeleza.application.dto.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoRequestDTO(

        @NotNull(message = "Hora do agendamento obrigatorio")
        LocalDateTime dataHora,
        @NotNull(message = "Id cliente obrigatorio")
        UUID clienteId,
        @NotNull(message = "Id servico obrigatorio")
        UUID servicoId,
        @NotNull(message = "Id profissional obrigatorio")
        UUID profissionalId
) {}
