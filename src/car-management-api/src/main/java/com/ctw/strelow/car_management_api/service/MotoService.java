package com.ctw.strelow.car_management_api.service;

import com.ctw.strelow.car_management_api.dto.moto.MotoRequestDTO;
import com.ctw.strelow.car_management_api.dto.moto.MotoResponseDTO;
import com.ctw.strelow.car_management_api.entity.Moto;
import com.ctw.strelow.car_management_api.repository.MotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MotoService {

    private final MotoRepository repository;

    public List<MotoResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(MotoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<MotoResponseDTO> buscarPorId(Long id) {
        return repository.findById(id).map(MotoResponseDTO::fromEntity);
    }

    public List<MotoResponseDTO> buscarPorMarca(String marca) {
        return repository.findByMarcaIgnoreCase(marca).stream()
                .map(MotoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<MotoResponseDTO> buscarPorPlaca(String placa) {
        return repository.findByPlaca(placa).map(MotoResponseDTO::fromEntity);
    }

    public MotoResponseDTO salvar(MotoRequestDTO dto) {
        Moto moto = new Moto();

        moto.setMarca(dto.marca());
        moto.setModelo(dto.modelo());
        moto.setAno(dto.ano());
        moto.setCor(dto.cor());
        moto.setPreco(dto.preco());
        moto.setPlaca(dto.placa());
        moto.setCilindradas(dto.cilindradas());

        return MotoResponseDTO.fromEntity(repository.save(moto));
    }

    public Optional<MotoResponseDTO> atualizar(Long id, MotoRequestDTO dto) {
        return repository.findById(id).map(existing -> {

            existing.setMarca(dto.marca());
            existing.setModelo(dto.modelo());
            existing.setAno(dto.ano());
            existing.setCor(dto.cor());
            existing.setPreco(dto.preco());
            existing.setPlaca(dto.placa());
            existing.setCilindradas(dto.cilindradas());

            return MotoResponseDTO.fromEntity(repository.save(existing));
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