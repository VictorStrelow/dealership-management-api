package com.ctw.strelow.car_management_api.dto.van;

import com.ctw.strelow.car_management_api.entity.Van;

public record VanResponseDTO(

        Long id,
        String marca,
        String modelo,
        String ano,
        String cor,
        Double preco,
        String placa,
        Integer capacidadePassageiros,
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