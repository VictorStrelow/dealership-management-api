package com.ctw.strelow.car_management_api.controller;

import com.ctw.strelow.car_management_api.dto.caminhao.CaminhaoRequestDTO;
import com.ctw.strelow.car_management_api.dto.caminhao.CaminhaoResponseDTO;
import com.ctw.strelow.car_management_api.service.CaminhaoService;
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
@RequestMapping("/api/caminhoes")
@RequiredArgsConstructor
@Tag(name = "Caminhões", description = "Endpoints para gerenciamento de caminhões da concessionária")
public class CaminhaoController {

    private final CaminhaoService service;

    @Operation(summary = "Listar todos os caminhões", description = "Retorna uma lista com todos os caminhões cadastrados")
    @GetMapping
    public List<CaminhaoResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @Operation(summary = "Buscar caminhão por ID", description = "Retorna um caminhão específico pelo seu ID")
    @GetMapping("/{id}")
    public ResponseEntity<CaminhaoResponseDTO> buscarPorId(
            @Parameter(description = "ID do caminhão", required = true, example = "1")
            @PathVariable Long id) {

        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Buscar caminhões por marca", description = "Retorna todos os caminhões de uma determinada marca")
    @GetMapping("/marca/{marca}")
    public List<CaminhaoResponseDTO> buscarPorMarca(
            @Parameter(description = "Nome da marca", required = true, example = "Volvo")
            @PathVariable String marca) {

        return service.buscarPorMarca(marca);
    }

    @Operation(summary = "Buscar caminhão por placa", description = "Retorna um caminhão pelo número de placa")
    @GetMapping("/placa/{placa}")
    public ResponseEntity<CaminhaoResponseDTO> buscarPorPlaca(
            @Parameter(description = "Placa do caminhão (ex: ABC1D23 ou ABC1234)", required = true, example = "ABC1D23")
            @PathVariable String placa) {

        return service.buscarPorPlaca(placa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Cadastrar novo caminhão", description = "Cria um novo registro de caminhão no sistema")
    @PostMapping
    public ResponseEntity<CaminhaoResponseDTO> salvar(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados do caminhão a ser cadastrado", required = true,
                    content = @Content(schema = @Schema(implementation = CaminhaoRequestDTO.class)))
            @RequestBody @Valid CaminhaoRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @Operation(summary = "Atualizar caminhão", description = "Atualiza os dados de um caminhão existente pelo ID")
    @PutMapping("/{id}")
    public ResponseEntity<CaminhaoResponseDTO> atualizar(
            @Parameter(description = "ID do caminhão a ser atualizado", required = true, example = "1")
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Novos dados do caminhão", required = true,
                    content = @Content(schema = @Schema(implementation = CaminhaoRequestDTO.class)))
            @RequestBody @Valid CaminhaoRequestDTO dto) {

        return service.atualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deletar caminhão", description = "Remove um caminhão do sistema pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do caminhão a ser removido", required = true, example = "1")
            @PathVariable Long id) {

        if (service.deletar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}