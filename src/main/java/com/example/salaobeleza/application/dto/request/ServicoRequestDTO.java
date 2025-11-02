package com.example.salaobeleza.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ServicoRequestDTO(

        @NotBlank(message = "Nome Obrigatorio")
        String nome,
        @NotBlank(message = "Descricao Obrigatorio")
        String descricao,
        @NotBlank(message = "Valor do Servico Obrigatorio")
        String valorServico,
        @NotBlank(message = "Duracao do Servico Obrigatorio")
        String duracaoMinutos
) {}
