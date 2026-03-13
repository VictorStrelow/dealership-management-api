package com.ctw.strelow.car_management_api.service;

import com.ctw.strelow.car_management_api.dto.caminhao.CaminhaoRequestDTO;
import com.ctw.strelow.car_management_api.dto.caminhao.CaminhaoResponseDTO;
import com.ctw.strelow.car_management_api.entity.Caminhao;
import com.ctw.strelow.car_management_api.repository.CaminhaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CaminhaoService {

    private final CaminhaoRepository repository;

    public List<CaminhaoResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(CaminhaoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<CaminhaoResponseDTO> buscarPorId(Long id) {
        return repository.findById(id).map(CaminhaoResponseDTO::fromEntity);
    }

    public List<CaminhaoResponseDTO> buscarPorMarca(String marca) {
        return repository.findByMarcaIgnoreCase(marca).stream()
                .map(CaminhaoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<CaminhaoResponseDTO> buscarPorPlaca(String placa) {
        return repository.findByPlaca(placa).map(CaminhaoResponseDTO::fromEntity);
    }

    public CaminhaoResponseDTO salvar(CaminhaoRequestDTO dto) {
        Caminhao caminhao = new Caminhao();

        caminhao.setMarca(dto.marca());
        caminhao.setModelo(dto.modelo());
        caminhao.setAno(dto.ano());
        caminhao.setCor(dto.cor());
        caminhao.setPreco(dto.preco());
        caminhao.setPlaca(dto.placa());
        caminhao.setEixos(dto.eixos());
        caminhao.setCapacidadeCarga(dto.capacidadeCarga());

        return CaminhaoResponseDTO.fromEntity(repository.save(caminhao));
    }

    public Optional<CaminhaoResponseDTO> atualizar(Long id, CaminhaoRequestDTO dto) {
        return repository.findById(id).map(existing -> {

            existing.setMarca(dto.marca());
            existing.setModelo(dto.modelo());
            existing.setAno(dto.ano());
            existing.setCor(dto.cor());
            existing.setPreco(dto.preco());
            existing.setPlaca(dto.placa());
            existing.setEixos(dto.eixos());
            existing.setCapacidadeCarga(dto.capacidadeCarga());

            return CaminhaoResponseDTO.fromEntity(repository.save(existing));
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