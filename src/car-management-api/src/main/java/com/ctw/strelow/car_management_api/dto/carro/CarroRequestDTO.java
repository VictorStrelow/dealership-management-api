package com.ctw.strelow.car_management_api.dto.carro;

import com.ctw.strelow.car_management_api.entity.Carro;
import jakarta.validation.constraints.*;

public record CarroRequestDTO(

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

        @NotNull(message = "O tipo de combustível é obrigatório!")
        Carro.tipoCombustivel tipoCombustivel

) {}