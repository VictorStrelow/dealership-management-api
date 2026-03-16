package com.ctw.strelow.car_management_api.controller;

import com.ctw.strelow.car_management_api.dto.van.VanRequestDTO;
import com.ctw.strelow.car_management_api.dto.van.VanResponseDTO;
import com.ctw.strelow.car_management_api.service.VanService;
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
@RequestMapping("/api/vans")
@RequiredArgsConstructor
@Tag(name = "Vans", description = "Endpoints para gerenciamento de vans da concessionária")
public class VanController {

    private final VanService service;

    @Operation(summary = "Listar todas as vans", description = "Retorna uma lista com todas as vans cadastradas")
    @GetMapping
    public List<VanResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @Operation(summary = "Buscar van por ID", description = "Retorna uma van específica pelo seu ID")
    @GetMapping("/{id}")
    public ResponseEntity<VanResponseDTO> buscarPorId(
            @Parameter(description = "ID da van", required = true, example = "1")
            @PathVariable Long id) {

        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Buscar vans por marca", description = "Retorna todas as vans de uma determinada marca")
    @GetMapping("/marca/{marca}")
    public List<VanResponseDTO> buscarPorMarca(
            @Parameter(description = "Nome da marca", required = true, example = "Mercedes-Benz")
            @PathVariable String marca) {

        return service.buscarPorMarca(marca);
    }

    @Operation(summary = "Buscar van por placa", description = "Retorna uma van pelo número de placa")
    @GetMapping("/placa/{placa}")
    public ResponseEntity<VanResponseDTO> buscarPorPlaca(
            @Parameter(description = "Placa da van", required = true, example = "ABC1D23")
            @PathVariable String placa) {

        return service.buscarPorPlaca(placa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Cadastrar nova van", description = "Cria um novo registro de van no sistema")
    @PostMapping
    public ResponseEntity<VanResponseDTO> salvar(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados da van a ser cadastrada", required = true,
                    content = @Content(schema = @Schema(implementation = VanRequestDTO.class)))
            @RequestBody @Valid VanRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @Operation(summary = "Atualizar van", description = "Atualiza os dados de uma van existente pelo ID")
    @PutMapping("/{id}")
    public ResponseEntity<VanResponseDTO> atualizar(
            @Parameter(description = "ID da van a ser atualizada", required = true, example = "1")
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Novos dados da van", required = true,
                    content = @Content(schema = @Schema(implementation = VanRequestDTO.class)))
            @RequestBody @Valid VanRequestDTO dto) {

        return service.atualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deletar van", description = "Remove uma van do sistema pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID da van a ser removida", required = true, example = "1")
            @PathVariable Long id) {

        if (service.deletar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}