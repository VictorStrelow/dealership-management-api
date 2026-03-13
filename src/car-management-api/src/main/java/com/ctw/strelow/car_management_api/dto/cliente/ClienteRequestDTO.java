package com.ctw.strelow.car_management_api.dto.cliente;

import jakarta.validation.constraints.*;

public record ClienteRequestDTO(

        @NotBlank(message = "O nome é obrigatório!")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
        String nome,

        @NotBlank(message = "O CPF é obrigatório!")
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve seguir o formato 000.000.000-00.")
        String cpf,

        @NotBlank(message = "O email é obrigatório!")
        @Email(message = "O email informado é inválido.")
        String email,

        @NotBlank(message = "O telefone é obrigatório!")
        @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "O telefone deve seguir o formato (00) 00000-0000.")
        String telefone,

        @NotBlank(message = "A cidade é obrigatória!")
        String cidade,

        @NotBlank(message = "O estado é obrigatório!")
        @Size(min = 2, max = 2, message = "O estado deve ser a sigla com 2 letras, ex: SP.")
        String estado

) {}