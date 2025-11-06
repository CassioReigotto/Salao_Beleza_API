package com.example.salaobeleza.application.mapper;

import com.example.salaobeleza.domain.model.Cliente;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ClienteIdMapper {

        default Cliente fromId(UUID id) {
            if (id == null) return null;
            Cliente c = new Cliente();
            c.setId(id);
            return c;
        }

        default UUID toId(Cliente c) {
            return c != null ? c.getId() : null;
        }
    }


