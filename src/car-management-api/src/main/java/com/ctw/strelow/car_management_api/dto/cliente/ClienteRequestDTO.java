package com.ctw.strelow.car_management_api.dto.cliente;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Dados para cadastro ou atualização de um cliente")
public record ClienteRequestDTO(

        @Schema(description = "Nome completo do cliente", example = "João da Silva", minLength = 3, maxLength = 100)
        @NotBlank(message = "O nome é obrigatório!")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
        String nome,

        @Schema(description = "CPF do cliente no formato 000.000.000-00", example = "123.456.789-00", pattern = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
        @NotBlank(message = "O CPF é obrigatório!")
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve seguir o formato 000.000.000-00.")
        String cpf,

        @Schema(description = "Endereço de e-mail do cliente", example = "exemplo@email.com")
        @NotBlank(message = "O email é obrigatório!")
        @Email(message = "O email informado é inválido.")
        String email,

        @Schema(description = "Telefone no formato (00) 00000-0000 ou (00) 0000-0000", example = "(11) 99999-0000", pattern = "\\(\\d{2}\\) \\d{4,5}-\\d{4}")
        @NotBlank(message = "O telefone é obrigatório!")
        @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "O telefone deve seguir o formato (00) 00000-0000.")
        String telefone,

        @Schema(description = "Cidade de residência do cliente", example = "Jaraguá do Sul")
        @NotBlank(message = "A cidade é obrigatória!")
        String cidade,

        @Schema(description = "Sigla do estado (UF) com 2 letras", example = "SC", minLength = 2, maxLength = 2)
        @NotBlank(message = "O estado é obrigatório!")
        @Size(min = 2, max = 2, message = "O estado deve ser a sigla com 2 letras, ex: SP.")
        String estado

) {}