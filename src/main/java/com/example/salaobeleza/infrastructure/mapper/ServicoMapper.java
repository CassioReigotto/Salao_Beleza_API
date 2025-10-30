package com.example.salaobeleza.infrastructure.mapper;


import com.example.salaobeleza.domain.model.Servico;
import com.example.salaobeleza.infrastructure.repository.entity.ServicoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServicoMapper {

    public ServicoEntity servicotoToServicoEntity(Servico servico);

    public Servico servicoEntityToServicoDomain(ServicoEntity servicoEntity);

}
