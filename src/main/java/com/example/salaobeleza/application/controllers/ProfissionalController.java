package com.example.salaobeleza.application.controllers;

import com.example.salaobeleza.application.dto.request.ProfissionalRequestDTO;
import com.example.salaobeleza.application.dto.response.ProfissionalResponseDTO;
import com.example.salaobeleza.application.mapper.ProfissionalDTOMapper;
import com.example.salaobeleza.domain.ports.in.Profissional.ProfissionalUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    private final ProfissionalUseCase profissionalUseCase;

    private final ProfissionalDTOMapper profissionalDTOMapper;

    public ProfissionalController(ProfissionalUseCase profissionalUseCase, ProfissionalDTOMapper profissionalDTOMapper) {
        this.profissionalUseCase = profissionalUseCase;
        this.profissionalDTOMapper = profissionalDTOMapper;
    }


    @GetMapping
    public ResponseEntity<List<ProfissionalResponseDTO>> findAll(){

            List<ProfissionalResponseDTO> profissionais = profissionalUseCase.buscarTodos()
                    .stream()
                    .map(profissionalDTOMapper::profissionalDomainToResponseDTO)
                    .toList();
            return ResponseEntity.ok(profissionais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalResponseDTO> findById(@PathVariable UUID id){
        return profissionalUseCase.buscarPorId(id)
                .map(profissionalDTOMapper::profissionalDomainToResponseDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProfissionalResponseDTO> criar(@Valid @RequestBody ProfissionalRequestDTO profissionalRequestDTO){
        var profissional = profissionalDTOMapper.profissionalRequestDTOToProfissionalDomain(profissionalRequestDTO);
        var criado = profissionalUseCase.criar(profissional);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(profissionalDTOMapper.profissionalDomainToResponseDTO(criado));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalResponseDTO> atualizar (@PathVariable("id") UUID id, @Valid @RequestBody ProfissionalRequestDTO profissionalRequestDTO){
        var profissionalAtualizado = profissionalDTOMapper.profissionalRequestDTOToProfissionalDomain(profissionalRequestDTO);
        profissionalAtualizado.setId(id);
        var profissional = profissionalUseCase.atualizar(profissionalAtualizado);
        return ResponseEntity.ok(profissionalDTOMapper.profissionalDomainToResponseDTO(profissional));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar (@PathVariable("id") UUID id){
        profissionalUseCase.deletarPorId(id);
        return ResponseEntity.ok("Cliente Excluido com sucesso!");
    }
}
