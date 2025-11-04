package com.example.salaobeleza.application.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoRequestDTO(

        @NotBlank(message = "Hora do agendamento obrigatorio")
        LocalDateTime dataHora,
        @NotBlank(message = "Id cliente obrigatorio")
        UUID clienteId,
        @NotBlank(message = "Id servico obrigatorio")
        UUID servicoId,
        @NotBlank(message = "Id profissional obrigatorio")
        UUID profissionalId
) {}
