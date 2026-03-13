package com.ctw.strelow.car_management_api.dto.caminhao;

import com.ctw.strelow.car_management_api.entity.Caminhao;
import jakarta.validation.constraints.*;

public record CaminhaoRequestDTO(

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

        @NotNull(message = "O número de eixos é obrigatório!")
        @Min(value = 2, message = "O caminhão deve ter no mínimo 2 eixos.")
        @Max(value = 9, message = "O caminhão deve ter no máximo 9 eixos.")
        Integer eixos,

        @NotNull(message = "A capacidade de carga é obrigatória!")
        @Positive(message = "A capacidade de carga deve ser maior que zero.")
        Double capacidadeCarga

) {}