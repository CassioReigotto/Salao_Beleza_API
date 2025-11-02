package com.example.salaobeleza.application.mapper;

import com.example.salaobeleza.application.dto.request.ClienteRequestDTO;
import com.example.salaobeleza.domain.model.Cliente;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ClienteDTOMapper {

    Cliente clienteRequestDTOToClienteDomain (ClienteRequestDTO dto);
    ClienteRequestDTO clienteDomainToClienteRequestDTO (Cliente cliente);

}
