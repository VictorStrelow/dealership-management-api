package com.ctw.strelow.car_management_api.controller;

import com.ctw.strelow.car_management_api.dto.carro.CarroRequestDTO;
import com.ctw.strelow.car_management_api.dto.carro.CarroResponseDTO;
import com.ctw.strelow.car_management_api.service.CarroService;
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
@RequestMapping("/api/carros")
@RequiredArgsConstructor
@Tag(name = "Carros", description = "Endpoints para gerenciamento de carros da concessionária")
public class CarroController {

    private final CarroService service;

    @Operation(summary = "Listar todos os carros", description = "Retorna uma lista com todos os carros cadastrados")
    @GetMapping
    public List<CarroResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @Operation(summary = "Buscar carro por ID", description = "Retorna um carro específico pelo seu ID")
    @GetMapping("/{id}")
    public ResponseEntity<CarroResponseDTO> buscarPorId(
            @Parameter(description = "ID do carro", required = true, example = "1")
            @PathVariable Long id) {

        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Buscar carros por marca", description = "Retorna todos os carros de uma determinada marca")
    @GetMapping("/marca/{marca}")
    public List<CarroResponseDTO> buscarPorMarca(
            @Parameter(description = "Nome da marca", required = true, example = "Toyota")
            @PathVariable String marca) {

        return service.buscarPorMarca(marca);
    }

    @Operation(summary = "Buscar carro por placa", description = "Retorna um carro pelo número de placa (formato Mercosul ou antigo)")
    @GetMapping("/placa/{placa}")
    public ResponseEntity<CarroResponseDTO> buscarPorPlaca(
            @Parameter(description = "Placa do carro", required = true, example = "ABC1D23")
            @PathVariable String placa) {

        return service.buscarPorPlaca(placa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Cadastrar novo carro", description = "Cria um novo registro de carro no sistema")
    @PostMapping
    public ResponseEntity<CarroResponseDTO> salvar(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados do carro a ser cadastrado", required = true,
                    content = @Content(schema = @Schema(implementation = CarroRequestDTO.class)))
            @RequestBody @Valid CarroRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @Operation(summary = "Atualizar carro", description = "Atualiza os dados de um carro existente pelo ID")
    @PutMapping("/{id}")
    public ResponseEntity<CarroResponseDTO> atualizar(
            @Parameter(description = "ID do carro a ser atualizado", required = true, example = "1")
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Novos dados do carro", required = true,
                    content = @Content(schema = @Schema(implementation = CarroRequestDTO.class)))
            @RequestBody @Valid CarroRequestDTO dto) {

        return service.atualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deletar carro", description = "Remove um carro do sistema pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do carro a ser removido", required = true, example = "1")
            @PathVariable Long id) {

        if (service.deletar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}