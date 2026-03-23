package com.ctw.strelow.car_management_api.dto.caminhao;

import com.ctw.strelow.car_management_api.entity.Caminhao;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados retornados de um caminhão cadastrado")
public record CaminhaoResponseDTO(

        @Schema(description = "Identificador único do caminhão", example = "1")
        Long id,

        @Schema(description = "Marca do caminhão", example = "Volvo")
        String marca,

        @Schema(description = "Modelo do caminhão", example = "FH 460")
        String modelo,

        @Schema(description = "Ano de fabricação do caminhão", example = "2023")
        String ano,

        @Schema(description = "Cor do caminhão", example = "Cinza")
        String cor,

        @Schema(description = "Preço do caminhão em reais", example = "550000.00")
        Double preco,

        @Schema(description = "Placa no formato Mercosul ou antigo", example = "ABC1D23")
        String placa,

        @Schema(description = "Número de eixos do caminhão", example = "3")
        Integer eixos,

        @Schema(description = "Capacidade de carga em toneladas", example = "25.5")
        Double capacidadeCarga

) {

    public static CaminhaoResponseDTO fromEntity(Caminhao caminhao) {
        return new CaminhaoResponseDTO(
                caminhao.getId(),
                caminhao.getMarca(),
                caminhao.getModelo(),
                caminhao.getAno(),
                caminhao.getCor(),
                caminhao.getPreco(),
                caminhao.getPlaca(),
                caminhao.getEixos(),
                caminhao.getCapacidadeCarga()
        );
    }

}