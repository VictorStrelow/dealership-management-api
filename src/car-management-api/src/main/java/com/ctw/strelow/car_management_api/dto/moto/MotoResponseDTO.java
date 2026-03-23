package com.ctw.strelow.car_management_api.dto.moto;

import com.ctw.strelow.car_management_api.entity.Moto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados retornados de uma moto cadastrada")
public record MotoResponseDTO(

        @Schema(description = "Identificador único da moto", example = "1")
        Long id,

        @Schema(description = "Marca da moto", example = "Honda")
        String marca,

        @Schema(description = "Modelo da moto", example = "Hornet")
        String modelo,

        @Schema(description = "Ano de fabricação da moto", example = "2023")
        String ano,

        @Schema(description = "Cor da moto", example = "Vermelho")
        String cor,

        @Schema(description = "Preço da moto em reais", example = "32500.00")
        Double preco,

        @Schema(description = "Placa no formato Mercosul ou antigo", example = "ABC1D23")
        String placa,

        @Schema(description = "Cilindradas do motor em cc", example = "500")
        Integer cilindradas

) {

    public static MotoResponseDTO fromEntity(Moto moto) {
        return new MotoResponseDTO(
                moto.getId(),
                moto.getMarca(),
                moto.getModelo(),
                moto.getAno(),
                moto.getCor(),
                moto.getPreco(),
                moto.getPlaca(),
                moto.getCilindradas()
        );
    }

}