package com.example.salaobeleza.application.mapper;

import com.example.salaobeleza.domain.model.Servico;
import org.mapstruct.Mapper;

import java.util.UUID;
@Mapper(componentModel = "spring")
public interface ServicoIdMapper {

    default Servico fromId(UUID id) {
        if (id == null) return null;
        Servico s = new Servico();
        s.setId(id);
        return s;
    }

    default UUID toId(Servico s) {
        return s != null ? s.getId() : null;
    }

}
