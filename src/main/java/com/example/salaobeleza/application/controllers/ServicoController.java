package com.example.salaobeleza.application.controllers;


import com.example.salaobeleza.application.dto.request.ServicoRequestDTO;
import com.example.salaobeleza.application.dto.response.ServicoResponseDTO;
import com.example.salaobeleza.application.mapper.ServicoDTOMapper;
import com.example.salaobeleza.domain.ports.in.Servico.ServicoUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(".servicos")
public class ServicoController {

    private final ServicoUseCase servicoUseCase;
    private final ServicoDTOMapper servicoDTOMapper;


    public ServicoController(ServicoUseCase servicoUseCase, ServicoDTOMapper servicoDTOMapper) {
        this.servicoUseCase = servicoUseCase;
        this.servicoDTOMapper = servicoDTOMapper;
    }

    @GetMapping
    public ResponseEntity<List<ServicoResponseDTO>> findAll(){
        List<ServicoResponseDTO> servicos = servicoUseCase.buscarTodos()
                .stream()
                .map(servicoDTOMapper::servicoDomainToServicoResponseDTO)
                .toList();
        return ResponseEntity.ok(servicos);
    }

    @GetMapping("{id}")
    public ResponseEntity<ServicoResponseDTO> buscarPorId(@PathVariable UUID id){
        return servicoUseCase.buscarPorId(id)
                .map(servicoDTOMapper::servicoDomainToServicoResponseDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ServicoResponseDTO> criar(@RequestBody ServicoRequestDTO servicoRequestDTO){
        var servico = servicoDTOMapper.servicoRequestDTOToServicoDomain(servicoRequestDTO);
        var criado  = servicoUseCase.criar(servico);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(servicoDTOMapper.servicoDomainToServicoResponseDTO(criado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> atualizar(@PathVariable UUID id, @Valid @RequestBody ServicoRequestDTO servicoRequestDTO){
        var servicoAtualizado = servicoDTOMapper.servicoRequestDTOToServicoDomain(servicoRequestDTO);
        servicoAtualizado.setId(id);
        var servico = servicoUseCase.atualizar(servicoAtualizado);
        return ResponseEntity.ok(servicoDTOMapper.servicoDomainToServicoResponseDTO(servico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable UUID id){
        servicoUseCase.deletar(id);
        return ResponseEntity.ok("Removido com sucesso");
    }
}
