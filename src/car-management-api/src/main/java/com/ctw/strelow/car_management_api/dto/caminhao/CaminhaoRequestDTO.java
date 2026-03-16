package com.ctw.strelow.car_management_api.dto.caminhao;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Dados para cadastro ou atualização de um caminhão")
public record CaminhaoRequestDTO(

        @Schema(description = "Marca do caminhão", example = "Volvo", minLength = 2, maxLength = 50)
        @NotBlank(message = "A marca é obrigatória!")
        @Size(min = 2, max = 50, message = "A marca deve ter entre 2 e 50 caracteres.")
        String marca,

        @Schema(description = "Modelo do caminhão", example = "FH 460", minLength = 1, maxLength = 100)
        @NotBlank(message = "O modelo é obrigatório!")
        @Size(min = 1, max = 100, message = "O modelo deve ter entre 1 e 100 caracteres.")
        String modelo,

        @Schema(description = "Ano de fabricação (4 dígitos)", example = "2023", pattern = "\\d{4}")
        @NotBlank(message = "O ano é obrigatório!")
        @Pattern(regexp = "\\d{4}", message = "O ano deve conter exatamente 4 dígitos.")
        String ano,

        @Schema(description = "Cor do caminhão", example = "Cinza")
        @NotBlank(message = "A cor é obrigatória!")
        String cor,

        @Schema(description = "Preço do caminhão em reais", example = "550000.00", minimum = "0.01")
        @NotNull(message = "O preço é obrigatório!")
        @Positive(message = "O preço deve ser maior que zero.")
        Double preco,

        @Schema(description = "Placa no formato Mercosul (ABC1D23) ou antigo (ABC1234)", example = "ABC1D23", pattern = "[A-Z]{3}\\d[A-Z0-9]\\d{2}")
        @NotBlank(message = "A placa é obrigatória!")
        @Pattern(regexp = "[A-Z]{3}\\d[A-Z0-9]\\d{2}", message = "A placa deve seguir o formato Mercosul ou antigo.")
        String placa,

        @Schema(description = "Número de eixos do caminhão (mínimo 2, máximo 9)", example = "3", minimum = "2", maximum = "9")
        @NotNull(message = "O número de eixos é obrigatório!")
        @Min(value = 2, message = "O caminhão deve ter no mínimo 2 eixos.")
        @Max(value = 9, message = "O caminhão deve ter no máximo 9 eixos.")
        Integer eixos,

        @Schema(description = "Capacidade de carga em toneladas", example = "25.5", minimum = "0.01")
        @NotNull(message = "A capacidade de carga é obrigatória!")
        @Positive(message = "A capacidade de carga deve ser maior que zero.")
        Double capacidadeCarga

) {}