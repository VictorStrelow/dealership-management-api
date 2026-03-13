package com.ctw.strelow.car_management_api.dto.cliente;

import com.ctw.strelow.car_management_api.entity.Cliente;

public record ClienteResponseDTO(

        Long id,
        String nome,
        String cpf,
        String email,
        String telefone,
        String cidade,
        String estado

) {

    public static ClienteResponseDTO fromEntity(Cliente cliente) {
        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getCidade(),
                cliente.getEstado()
        );
    }

}