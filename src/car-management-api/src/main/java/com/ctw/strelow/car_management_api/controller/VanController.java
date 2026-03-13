package com.ctw.strelow.car_management_api.controller;

import com.ctw.strelow.car_management_api.dto.van.VanRequestDTO;
import com.ctw.strelow.car_management_api.dto.van.VanResponseDTO;
import com.ctw.strelow.car_management_api.service.VanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vans")
@RequiredArgsConstructor
public class VanController {

    private final VanService service;

    @GetMapping
    public List<VanResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VanResponseDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/marca/{marca}")
    public List<VanResponseDTO> buscarPorMarca(@PathVariable String marca) {
        return service.buscarPorMarca(marca);
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<VanResponseDTO> buscarPorPlaca(@PathVariable String placa) {
        return service.buscarPorPlaca(placa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VanResponseDTO> salvar(@RequestBody @Valid VanRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VanResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid VanRequestDTO dto) {
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
