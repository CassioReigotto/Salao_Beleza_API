package com.example.salaobeleza.application.controllers;


import com.example.salaobeleza.application.dto.request.ClienteRequestDTO;
import com.example.salaobeleza.application.dto.response.ClienteResponseDTO;
import com.example.salaobeleza.application.mapper.ClienteDTOMapper;
import com.example.salaobeleza.domain.ports.in.Cliente.ClienteUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteUseCase clienteUseCase;

    private final ClienteDTOMapper clienteDTOMapper;


    public ClienteController(ClienteUseCase clienteUseCase, ClienteDTOMapper clienteDTOMapper) {
        this.clienteUseCase = clienteUseCase;
        this.clienteDTOMapper = clienteDTOMapper;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> findAll() {
        // buscar todos
        List<ClienteResponseDTO> clientes = clienteUseCase.buscarTodos()
                .stream()
                .map(clienteDTOMapper::clienteDomainToClienteResponseDTO)
                .toList();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@Valid @PathVariable("id") UUID id){
        return clienteUseCase.buscarPorId(id)
                .map(clienteDTOMapper::clienteDomainToClienteResponseDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> criar(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO){
        var cliente =  clienteDTOMapper.clienteRequestDTOToClienteDomain(clienteRequestDTO);
        var criado = clienteUseCase.criar(cliente);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clienteDTOMapper.clienteDomainToClienteResponseDTO(criado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizar (@PathVariable("id") UUID id, @Valid @RequestBody ClienteRequestDTO clienteRequestDTO){

        var clienteAtualizado = clienteDTOMapper.clienteRequestDTOToClienteDomain(clienteRequestDTO);
        clienteAtualizado.setId(id);
        var cliente =  clienteUseCase.atualizar(clienteAtualizado);
        return ResponseEntity.ok(clienteDTOMapper.clienteDomainToClienteResponseDTO(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover (@PathVariable("id") UUID id){
        clienteUseCase.deletarPorId(id);
        return ResponseEntity.ok("Cliente excluido com sucesso");
    }

}
