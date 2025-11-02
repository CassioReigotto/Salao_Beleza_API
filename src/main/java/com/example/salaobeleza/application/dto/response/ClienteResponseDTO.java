package com.example.salaobeleza.application.dto.response;

import java.util.UUID;

public record ClienteResponseDTO(

        UUID id,
        String nome,
        String email,
        String cpf,
        String telefone

) {}
