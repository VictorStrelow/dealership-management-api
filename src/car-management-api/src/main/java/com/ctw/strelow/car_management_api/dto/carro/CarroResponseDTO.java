package com.ctw.strelow.car_management_api.dto.carro;

import com.ctw.strelow.car_management_api.entity.Carro;

public record CarroResponseDTO(

        Long id,
        String marca,
        String modelo,
        String ano,
        String cor,
        Double preco,
        String placa,
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