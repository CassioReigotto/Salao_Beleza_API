package com.example.salaobeleza.infrastructure.mapper;

import com.example.salaobeleza.domain.model.Cliente;
import com.example.salaobeleza.domain.model.valueobject.Cpf;
import com.example.salaobeleza.domain.model.valueobject.Email;
import com.example.salaobeleza.infrastructure.repository.entity.ClienteEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface ClienteMapper {


    @Mapping(source = "cpf.numero" , target = "cpf")
    @Mapping(source = "email.endereco" , target = "email")
    public ClienteEntity clienteDomainToClienteEntity(Cliente cliente);


    @InheritInverseConfiguration
    public Cliente clienteEntityToClienteDomain(ClienteEntity clienteEntity);





}
