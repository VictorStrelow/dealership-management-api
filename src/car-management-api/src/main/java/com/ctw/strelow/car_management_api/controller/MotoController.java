package com.ctw.strelow.car_management_api.controller;

import com.ctw.strelow.car_management_api.dto.moto.MotoRequestDTO;
import com.ctw.strelow.car_management_api.dto.moto.MotoResponseDTO;
import com.ctw.strelow.car_management_api.service.MotoService;
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
@RequestMapping("/api/motos")
@RequiredArgsConstructor
@Tag(name = "Motos", description = "Endpoints para gerenciamento de motos da concessionária")
public class MotoController {

    private final MotoService service;

    @Operation(summary = "Listar todas as motos", description = "Retorna uma lista com todas as motos cadastradas")
    @GetMapping
    public List<MotoResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @Operation(summary = "Buscar moto por ID", description = "Retorna uma moto específica pelo seu ID")
    @GetMapping("/{id}")
    public ResponseEntity<MotoResponseDTO> buscarPorId(
            @Parameter(description = "ID da moto", required = true, example = "1")
            @PathVariable Long id) {

        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Buscar motos por marca", description = "Retorna todas as motos de uma determinada marca")
    @GetMapping("/marca/{marca}")
    public List<MotoResponseDTO> buscarPorMarca(
            @Parameter(description = "Nome da marca", required = true, example = "Honda")
            @PathVariable String marca) {

        return service.buscarPorMarca(marca);
    }

    @Operation(summary = "Buscar moto por placa", description = "Retorna uma moto pelo número de placa")
    @GetMapping("/placa/{placa}")
    public ResponseEntity<MotoResponseDTO> buscarPorPlaca(
            @Parameter(description = "Placa da moto", required = true, example = "ABC1D23")
            @PathVariable String placa) {

        return service.buscarPorPlaca(placa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Cadastrar nova moto", description = "Cria um novo registro de moto no sistema")
    @PostMapping
    public ResponseEntity<MotoResponseDTO> salvar(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados da moto a ser cadastrada", required = true,
                    content = @Content(schema = @Schema(implementation = MotoRequestDTO.class)))
            @RequestBody @Valid MotoRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @Operation(summary = "Atualizar moto", description = "Atualiza os dados de uma moto existente pelo ID")
    @PutMapping("/{id}")
    public ResponseEntity<MotoResponseDTO> atualizar(
            @Parameter(description = "ID da moto a ser atualizada", required = true, example = "1")
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Novos dados da moto", required = true,
                    content = @Content(schema = @Schema(implementation = MotoRequestDTO.class)))
            @RequestBody @Valid MotoRequestDTO dto) {

        return service.atualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deletar moto", description = "Remove uma moto do sistema pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID da moto a ser removida", required = true, example = "1")
            @PathVariable Long id) {

        if (service.deletar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}