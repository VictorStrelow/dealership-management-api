package com.ctw.strelow.car_management_api.service;

import com.ctw.strelow.car_management_api.dto.cliente.ClienteRequestDTO;
import com.ctw.strelow.car_management_api.dto.cliente.ClienteResponseDTO;
import com.ctw.strelow.car_management_api.entity.Cliente;
import com.ctw.strelow.car_management_api.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public List<ClienteResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(ClienteResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<ClienteResponseDTO> buscarPorId(Long id) {
        return repository.findById(id).map(ClienteResponseDTO::fromEntity);
    }

    public Optional<ClienteResponseDTO> buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf).map(ClienteResponseDTO::fromEntity);
    }

    public List<ClienteResponseDTO> buscarPorCidade(String cidade) {
        return repository.findByCidadeIgnoreCase(cidade).stream()
                .map(ClienteResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public ClienteResponseDTO salvar(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();

        cliente.setNome(dto.nome());
        cliente.setCpf(dto.cpf());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());
        cliente.setCidade(dto.cidade());
        cliente.setEstado(dto.estado());

        return ClienteResponseDTO.fromEntity(repository.save(cliente));
    }

    public Optional<ClienteResponseDTO> atualizar(Long id, ClienteRequestDTO dto) {
        return repository.findById(id).map(existing -> {

            existing.setNome(dto.nome());
            existing.setCpf(dto.cpf());
            existing.setEmail(dto.email());
            existing.setTelefone(dto.telefone());
            existing.setCidade(dto.cidade());
            existing.setEstado(dto.estado());

            return ClienteResponseDTO.fromEntity(repository.save(existing));
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