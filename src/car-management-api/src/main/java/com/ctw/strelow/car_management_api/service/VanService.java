package com.ctw.strelow.car_management_api.service;

import com.ctw.strelow.car_management_api.dto.van.VanRequestDTO;
import com.ctw.strelow.car_management_api.dto.van.VanResponseDTO;
import com.ctw.strelow.car_management_api.entity.Van;
import com.ctw.strelow.car_management_api.repository.VanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VanService {

    private final VanRepository repository;

    public List<VanResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(VanResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<VanResponseDTO> buscarPorId(Long id) {
        return repository.findById(id).map(VanResponseDTO::fromEntity);
    }

    public List<VanResponseDTO> buscarPorMarca(String marca) {
        return repository.findByMarcaIgnoreCase(marca).stream()
                .map(VanResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<VanResponseDTO> buscarPorPlaca(String placa) {
        return repository.findByPlaca(placa).map(VanResponseDTO::fromEntity);
    }

    public VanResponseDTO salvar(VanRequestDTO dto) {
        Van van = new Van();

        van.setMarca(dto.marca());
        van.setModelo(dto.modelo());
        van.setAno(dto.ano());
        van.setCor(dto.cor());
        van.setPreco(dto.preco());
        van.setPlaca(dto.placa());
        van.setCapacidadePassageiros(dto.capacidadePassageiros());
        van.setAdaptadaPCD(dto.adaptadaPCD());

        return VanResponseDTO.fromEntity(repository.save(van));
    }

    public Optional<VanResponseDTO> atualizar(Long id, VanRequestDTO dto) {
        return repository.findById(id).map(existing -> {

            existing.setMarca(dto.marca());
            existing.setModelo(dto.modelo());
            existing.setAno(dto.ano());
            existing.setCor(dto.cor());
            existing.setPreco(dto.preco());
            existing.setPlaca(dto.placa());
            existing.setCapacidadePassageiros(dto.capacidadePassageiros());
            existing.setAdaptadaPCD(dto.adaptadaPCD());

            return VanResponseDTO.fromEntity(repository.save(existing));
        });
    }

    public boolean deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

}