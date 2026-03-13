package com.ctw.strelow.car_management_api.dto.moto;

import com.ctw.strelow.car_management_api.entity.Moto;

public record MotoResponseDTO(

        Long id,
        String marca,
        String modelo,
        String ano,
        String cor,
        Double preco,
        String placa,
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