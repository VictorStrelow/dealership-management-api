package com.ctw.strelow.car_management_api.dto.van;

import com.ctw.strelow.car_management_api.entity.Van;
import jakarta.validation.constraints.*;

public record VanRequestDTO(

        @NotBlank(message = "A marca é obrigatória!")
        @Size(min = 2, max = 50, message = "A marca deve ter entre 2 e 50 caracteres.")
        String marca,

        @NotBlank(message = "O modelo é obrigatório!")
        @Size(min = 1, max = 100, message = "O modelo deve ter entre 1 e 100 caracteres.")
        String modelo,

        @NotBlank(message = "O ano é obrigatório!")
        @Pattern(regexp = "\\d{4}", message = "O ano deve conter exatamente 4 dígitos.")
        String ano,

        @NotBlank(message = "A cor é obrigatória!")
        String cor,

        @NotNull(message = "O preço é obrigatório!")
        @Positive(message = "O preço deve ser maior que zero.")
        Double preco,

        @NotBlank(message = "A placa é obrigatória!")
        @Pattern(regexp = "[A-Z]{3}\\d[A-Z0-9]\\d{2}", message = "A placa deve seguir o formato Mercosul ou antigo.")
        String placa,

        @NotNull(message = "A capacidade de passageiros é obrigatória!")
        @Min(value = 1, message = "A capacidade deve ser de no mínimo 1 passageiro.")
        @Max(value = 30, message = "A capacidade deve ser de no máximo 30 passageiros.")
        Integer capacidadePassageiros,

        @NotNull(message = "Informe se a van é adaptada para PCD.")
        Boolean adaptadaPCD

) {}