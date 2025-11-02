package com.example.salaobeleza.application.dto.response;

import com.example.salaobeleza.domain.model.enums.Especialidade;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

public record ProfissionalResponseDTO(

        UUID id,
        String nome,
        String email,
        String telefone,
        Especialidade especialidade,
        DayOfWeek diaSemana,
        LocalTime horarioInicio,
        LocalTime horarioFim

) {}
