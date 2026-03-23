package com.ctw.strelow.car_management_api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "caminhoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entidade que representa um caminhão cadastrado na concessionária")
public class Caminhao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do caminhão", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Marca do caminhão", example = "Volvo")
    private String marca;

    @Column(nullable = false)
    @Schema(description = "Modelo do caminhão", example = "FH 460")
    private String modelo;

    @Column(nullable = false)
    @Schema(description = "Ano de fabricação do caminhão (4 dígitos)", example = "2023")
    private String ano;

    @Column(nullable = false)
    @Schema(description = "Cor do caminhão", example = "Cinza")
    private String cor;

    @Column(nullable = false)
    @Schema(description = "Preço do caminhão em reais", example = "550000.00")
    private Double preco;

    @Column(nullable = false, unique = true)
    @Schema(description = "Placa no formato Mercosul (ABC1D23) ou antigo (ABC1234)", example = "ABC1D23")
    private String placa;

    @Column(nullable = false)
    @Schema(description = "Capacidade de carga em toneladas", example = "25.5")
    private Double capacidadeCarga;

    @Column(nullable = false)
    @Schema(description = "Número de eixos do caminhão (mínimo 2, máximo 9)", example = "3")
    private Integer eixos;

}