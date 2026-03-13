package com.ctw.strelow.car_management_api.service;

import com.ctw.strelow.car_management_api.dto.carro.CarroRequestDTO;
import com.ctw.strelow.car_management_api.dto.carro.CarroResponseDTO;
import com.ctw.strelow.car_management_api.entity.Carro;
import com.ctw.strelow.car_management_api.repository.CarroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarroService {

    private final CarroRepository repository;

    public List<CarroResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(CarroResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<CarroResponseDTO> buscarPorId(Long id) {
        return repository.findById(id).map(CarroResponseDTO::fromEntity);
    }

    public List<CarroResponseDTO> buscarPorMarca(String marca) {
        return repository.findByMarcaIgnoreCase(marca).stream()
                .map(CarroResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<CarroResponseDTO> buscarPorPlaca(String placa) {
        return repository.findByPlaca(placa).map(CarroResponseDTO::fromEntity);
    }

    public CarroResponseDTO salvar(CarroRequestDTO dto) {
        Carro carro = new Carro();

        carro.setMarca(dto.marca());
        carro.setModelo(dto.modelo());
        carro.setAno(dto.ano());
        carro.setCor(dto.cor());
        carro.setPreco(dto.preco());
        carro.setPlaca(dto.placa());
        carro.setTipoCombustivel(dto.tipoCombustivel());

        return CarroResponseDTO.fromEntity(repository.save(carro));
    }

    public Optional<CarroResponseDTO> atualizar(Long id, CarroRequestDTO dto) {
        return repository.findById(id).map(existing -> {

            existing.setMarca(dto.marca());
            existing.setModelo(dto.modelo());
            existing.setAno(dto.ano());
            existing.setCor(dto.cor());
            existing.setPreco(dto.preco());
            existing.setPlaca(dto.placa());
            existing.setTipoCombustivel(dto.tipoCombustivel());

            return CarroResponseDTO.fromEntity(repository.save(existing));
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