package com.example.salaobeleza.application.dto.request;

import com.example.salaobeleza.domain.model.enums.Especialidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;

public record ProfissionalRequestDTO(

        @NotBlank(message = "Nome obrigatório")
        String nome,

        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "Telefone obrigatório")
        String telefone,

        @NotNull(message = "Especialidade obrigatória")
        Especialidade especialidade,

        @NotNull(message = "Dia de semana obrigatório")
        Integer diaSemana,

        @NotNull(message = "Horário inicial obrigatório")
        LocalTime horarioInicio,

        @NotNull(message = "Horário final obrigatório")
        LocalTime horarioFim

) {}
