package com.ctw.strelow.car_management_api.dto.moto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Dados para cadastro ou atualização de uma moto")
public record MotoRequestDTO(

        @Schema(description = "Marca da moto", example = "Honda", minLength = 2, maxLength = 50)
        @NotBlank(message = "A marca é obrigatória!")
        @Size(min = 2, max = 50, message = "A marca deve ter entre 2 e 50 caracteres.")
        String marca,

        @Schema(description = "Modelo da moto", example = "Hornet", minLength = 1, maxLength = 100)
        @NotBlank(message = "O modelo é obrigatório!")
        @Size(min = 1, max = 100, message = "O modelo deve ter entre 1 e 100 caracteres.")
        String modelo,

        @Schema(description = "Ano de fabricação (4 dígitos)", example = "2023", pattern = "\\d{4}")
        @NotBlank(message = "O ano é obrigatório!")
        @Pattern(regexp = "\\d{4}", message = "O ano deve conter exatamente 4 dígitos.")
        String ano,

        @Schema(description = "Cor da moto", example = "Vermelho")
        @NotBlank(message = "A cor é obrigatória!")
        String cor,

        @Schema(description = "Preço da moto em reais", example = "32500.00", minimum = "0.01")
        @NotNull(message = "O preço é obrigatório!")
        @Positive(message = "O preço deve ser maior que zero.")
        Double preco,

        @Schema(description = "Placa no formato Mercosul (ABC1D23) ou antigo (ABC1234)", example = "ABC1D23", pattern = "[A-Z]{3}\\d[A-Z0-9]\\d{2}")
        @NotBlank(message = "A placa é obrigatória!")
        @Pattern(regexp = "[A-Z]{3}\\d[A-Z0-9]\\d{2}", message = "A placa deve seguir o formato Mercosul ou antigo.")
        String placa,

        @Schema(description = "Cilindradas do motor (cc)", example = "500", minimum = "1")
        @NotNull(message = "As cilindradas são obrigatórias!")
        @Positive(message = "As cilindradas devem ser maior que zero.")
        Integer cilindradas

) {}