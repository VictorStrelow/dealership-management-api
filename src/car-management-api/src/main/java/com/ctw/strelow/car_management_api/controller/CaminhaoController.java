package com.ctw.strelow.car_management_api.controller;

import com.ctw.strelow.car_management_api.dto.caminhao.CaminhaoRequestDTO;
import com.ctw.strelow.car_management_api.dto.caminhao.CaminhaoResponseDTO;
import com.ctw.strelow.car_management_api.service.CaminhaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/caminhoes")
@RequiredArgsConstructor
public class CaminhaoController {

    private final CaminhaoService service;

    @GetMapping
    public List<CaminhaoResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaminhaoResponseDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/marca/{marca}")
    public List<CaminhaoResponseDTO> buscarPorMarca(@PathVariable String marca) {
        return service.buscarPorMarca(marca);
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<CaminhaoResponseDTO> buscarPorPlaca(@PathVariable String placa) {
        return service.buscarPorPlaca(placa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CaminhaoResponseDTO> salvar(@RequestBody @Valid CaminhaoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CaminhaoResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid CaminhaoRequestDTO dto) {
        return service.atualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.deletar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}