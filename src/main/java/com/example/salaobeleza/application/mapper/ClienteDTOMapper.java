package com.example.salaobeleza.application.mapper;

import com.example.salaobeleza.application.dto.request.ClienteRequestDTO;
import com.example.salaobeleza.application.dto.response.ClienteResponseDTO;
import com.example.salaobeleza.domain.model.Cliente;
import com.example.salaobeleza.domain.model.valueobject.Cpf;
import com.example.salaobeleza.domain.model.valueobject.Email;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ClienteDTOMapper {

    Cliente clienteRequestDTOToClienteDomain (ClienteRequestDTO dto);
    ClienteResponseDTO clienteDomainToClienteResponseDTO (Cliente cliente);

    default Email map(String value) {
        return new Email(value);
    }

    default String map(Email email) {
        return email != null ? email.getEndereco() : null;
    }

    default Cpf mapCpf(String value) {
        return new Cpf(value);
    }

    default String mapCpf(Cpf cpf) {
        return cpf != null ? cpf.getNumero() : null;
    }

}
