package com.example.salaobeleza.application.mapper;

import com.example.salaobeleza.domain.model.Profissional;
import org.mapstruct.Mapper;

import java.util.UUID;
@Mapper(componentModel = "spring")
public interface ProfissionalIdMapper {

    default Profissional fromId(UUID id) {
        if (id == null) return null;
        Profissional p = new Profissional();
        p.setId(id);
        return p;
    }

    default UUID toId(Profissional p) {
        return p != null ? p.getId() : null;
    }
}
