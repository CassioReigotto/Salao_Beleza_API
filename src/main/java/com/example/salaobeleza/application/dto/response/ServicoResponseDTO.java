package com.example.salaobeleza.application.dto.response;

import java.util.UUID;

public record ServicoResponseDTO(

        UUID id,
        String nome,
        String descricao,
        String valorServico,
        String duracaoMinutos

) {}
