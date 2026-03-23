package com.ctw.strelow.car_management_api.dto.carro;

import com.ctw.strelow.car_management_api.entity.Carro;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados retornados de um carro cadastrado")
public record CarroResponseDTO(

        @Schema(description = "Identificador único do carro", example = "1")
        Long id,

        @Schema(description = "Marca do carro", example = "Toyota")
        String marca,

        @Schema(description = "Modelo do carro", example = "Hilux")
        String modelo,

        @Schema(description = "Ano de fabricação do carro", example = "2022")
        String ano,

        @Schema(description = "Cor do carro", example = "Prata")
        String cor,

        @Schema(description = "Preço do carro em reais", example = "129890.00")
        Double preco,

        @Schema(description = "Placa no formato Mercosul ou antigo", example = "ABC1D23")
        String placa,

        @Schema(description = "Tipo de combustível do carro",
                allowableValues = {"GASOLINE", "ETHANOL", "FLEX", "DIESEL", "ELECTRIC", "HYBRID"})
        Carro.tipoCombustivel tipoCombustivel

) {

    public static CarroResponseDTO fromEntity(Carro carro) {
        return new CarroResponseDTO(
                carro.getId(),
                carro.getMarca(),
                carro.getModelo(),
                carro.getAno(),
                carro.getCor(),
                carro.getPreco(),
                carro.getPlaca(),
                carro.getTipoCombustivel()
        );
    }

}