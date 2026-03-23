package com.ctw.strelow.car_management_api.dto.cliente;

import com.ctw.strelow.car_management_api.entity.Cliente;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados retornados de um cliente cadastrado")
public record ClienteResponseDTO(

        @Schema(description = "Identificador único do cliente", example = "1")
        Long id,

        @Schema(description = "Nome completo do cliente", example = "João da Silva")
        String nome,

        @Schema(description = "CPF do cliente no formato 000.000.000-00", example = "123.456.789-00")
        String cpf,

        @Schema(description = "Endereço de e-mail do cliente", example = "exemplo@email.com")
        String email,

        @Schema(description = "Telefone no formato (00) 00000-0000 ou (00) 0000-0000", example = "(11) 99999-0000")
        String telefone,

        @Schema(description = "Cidade de residência do cliente", example = "Jaraguá do Sul")
        String cidade,

        @Schema(description = "Sigla do estado (UF)", example = "SC")
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