package com.ctw.strelow.car_management_api.dto.caminhao;

import com.ctw.strelow.car_management_api.entity.Caminhao;

public record CaminhaoResponseDTO(

        Long id,
        String marca,
        String modelo,
        String ano,
        String cor,
        Double preco,
        String placa,
        Integer eixos,
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