package com.ctw.strelow.car_management_api.controller;

import com.ctw.strelow.car_management_api.dto.cliente.ClienteRequestDTO;
import com.ctw.strelow.car_management_api.dto.cliente.ClienteResponseDTO;
import com.ctw.strelow.car_management_api.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
@Tag(name = "Clientes", description = "Endpoints para gerenciamento de clientes da concessionária")
public class ClienteController {

    private final ClienteService service;

    @Operation(summary = "Listar todos os clientes", description = "Retorna uma lista com todos os clientes cadastrados")
    @GetMapping
    public List<ClienteResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @Operation(summary = "Buscar cliente por ID", description = "Retorna um cliente específico pelo seu ID")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(
            @Parameter(description = "ID do cliente", required = true, example = "1")
            @PathVariable Long id) {

        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Buscar cliente por CPF", description = "Retorna um cliente pelo número de CPF")
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ClienteResponseDTO> buscarPorCpf(
            @Parameter(description = "CPF do cliente no formato 000.000.000-00", required = true, example = "123.456.789-10")
            @PathVariable String cpf) {

        return service.buscarPorCpf(cpf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Buscar clientes por cidade", description = "Retorna todos os clientes de uma determinada cidade")
    @GetMapping("/cidade/{cidade}")
    public List<ClienteResponseDTO> buscarPorCidade(
            @Parameter(description = "Nome da cidade", required = true, example = "Jaraguá do Sul")
            @PathVariable String cidade) {

        return service.buscarPorCidade(cidade);
    }

    @Operation(summary = "Cadastrar novo cliente", description = "Cria um novo registro de cliente no sistema")
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> salvar(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados do cliente a ser cadastrado", required = true,
                    content = @Content(schema = @Schema(implementation = ClienteRequestDTO.class)))
            @RequestBody @Valid ClienteRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @Operation(summary = "Atualizar cliente", description = "Atualiza os dados de um cliente existente pelo ID")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizar(
            @Parameter(description = "ID do cliente a ser atualizado", required = true, example = "1")
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Novos dados do cliente", required = true,
                    content = @Content(schema = @Schema(implementation = ClienteRequestDTO.class)))
            @RequestBody @Valid ClienteRequestDTO dto) {

        return service.atualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deletar cliente", description = "Remove um cliente do sistema pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do cliente a ser removido", required = true, example = "1")
            @PathVariable Long id) {

        if (service.deletar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}