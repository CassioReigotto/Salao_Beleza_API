package com.example.salaobeleza.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteRequestDTO(

        @NotBlank(message = "Nome Obrigatorio")
        String nome,
        @Email(message = "Email invalido")
        String email,
        @NotBlank(message = "Cpf Obrigatorio")
        String cpf,
        @NotBlank(message = "Telefone Obrigatorio")
        String telefone
) {}


