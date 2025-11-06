package com.example.salaobeleza.infrastructure.mapper;

import com.example.salaobeleza.domain.model.Cliente;
import com.example.salaobeleza.domain.model.valueobject.Cpf;
import com.example.salaobeleza.domain.model.valueobject.Email;
import com.example.salaobeleza.infrastructure.repository.entity.ClienteEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {


    @Mapping(source = "cpf" , target = "cpf")
    @Mapping(source = "email" , target = "email")
     ClienteEntity clienteDomainToClienteEntity(Cliente cliente);


    @InheritInverseConfiguration
     Cliente clienteEntityToClienteDomain(ClienteEntity clienteEntity);


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
