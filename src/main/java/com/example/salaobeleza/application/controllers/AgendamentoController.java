package com.example.salaobeleza.application.controllers;


import com.example.salaobeleza.application.dto.request.AgendamentoRequestDTO;
import com.example.salaobeleza.application.dto.response.AgendamentoResponseDTO;
import com.example.salaobeleza.application.mapper.AgendamentoDTOMapper;
import com.example.salaobeleza.domain.ports.in.Agendamento.AgendamentoUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoDTOMapper agendamentoDTOMapper;
    private final AgendamentoUseCase agendamentoUseCase;


    public AgendamentoController(AgendamentoDTOMapper agendamentoDTOMapper, AgendamentoUseCase agendamentoUseCase) {
        this.agendamentoDTOMapper = agendamentoDTOMapper;
        this.agendamentoUseCase = agendamentoUseCase;
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponseDTO>> findAll(){
        List<AgendamentoResponseDTO> agendamento = agendamentoUseCase.buscarTodos()
                .stream()
                .map(agendamentoDTOMapper::agendamentoDomainToAgendamentoResponseDTO)
                .toList();
        return ResponseEntity.ok(agendamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponseDTO> BuscarPorId(@Valid @PathVariable("id") UUID id){
        return agendamentoUseCase.buscarPorId(id)
                .map(agendamentoDTOMapper::agendamentoDomainToAgendamentoResponseDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> criar(@Valid @RequestBody AgendamentoRequestDTO agendamentoRequestDTO){
        var agendamento = agendamentoDTOMapper.agendamentoRequestDTOToAgendamentoDomain(agendamentoRequestDTO);
        var criado =  agendamentoUseCase.criar(agendamento);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(agendamentoDTOMapper.agendamentoDomainToAgendamentoResponseDTO(criado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoResponseDTO> atualizar (@Valid @PathVariable("id") UUID id, @Valid @RequestBody AgendamentoRequestDTO agendamentoRequestDTO){
        var agendamentoAtualizado = agendamentoDTOMapper.agendamentoRequestDTOToAgendamentoDomain(agendamentoRequestDTO);
        agendamentoAtualizado.setId(id);
        var agendamento = agendamentoUseCase.atualizar(agendamentoAtualizado);
        return  ResponseEntity.ok(agendamentoDTOMapper.agendamentoDomainToAgendamentoResponseDTO(agendamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable("id") UUID id){
        agendamentoUseCase.deletar(id);
        return ResponseEntity.ok("Agendamento removido com sucesso");
    }
}
