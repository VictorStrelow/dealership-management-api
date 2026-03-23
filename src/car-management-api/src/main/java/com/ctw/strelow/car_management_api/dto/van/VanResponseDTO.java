package com.ctw.strelow.car_management_api.dto.van;

import com.ctw.strelow.car_management_api.entity.Van;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados retornados de uma van cadastrada")
public record VanResponseDTO(

        @Schema(description = "Identificador único da van", example = "1")
        Long id,

        @Schema(description = "Marca da van", example = "Mercedes-Benz")
        String marca,

        @Schema(description = "Modelo da van", example = "Sprinter 415")
        String modelo,

        @Schema(description = "Ano de fabricação da van", example = "2022")
        String ano,

        @Schema(description = "Cor da van", example = "Branco")
        String cor,

        @Schema(description = "Preço da van em reais", example = "250000.00")
        Double preco,

        @Schema(description = "Placa no formato Mercosul ou antigo", example = "ABC1D23")
        String placa,

        @Schema(description = "Capacidade máxima de passageiros", example = "15")
        Integer capacidadePassageiros,

        @Schema(description = "Indica se a van é adaptada para Pessoas com Deficiência (PCD)", example = "false")
        Boolean adaptadaPCD

) {

    public static VanResponseDTO fromEntity(Van van) {
        return new VanResponseDTO(
                van.getId(),
                van.getMarca(),
                van.getModelo(),
                van.getAno(),
                van.getCor(),
                van.getPreco(),
                van.getPlaca(),
                van.getCapacidadePassageiros(),
                van.getAdaptadaPCD()
        );
    }

}