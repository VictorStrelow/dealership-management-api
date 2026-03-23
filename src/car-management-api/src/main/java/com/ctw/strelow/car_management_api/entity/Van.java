package com.ctw.strelow.car_management_api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vans")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entidade que representa uma van cadastrada na concessionária")
public class Van {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único da van", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Marca da van", example = "Mercedes-Benz")
    private String marca;

    @Column(nullable = false)
    @Schema(description = "Modelo da van", example = "Sprinter 415")
    private String modelo;

    @Column(nullable = false)
    @Schema(description = "Ano de fabricação da van (4 dígitos)", example = "2022")
    private String ano;

    @Column(nullable = false)
    @Schema(description = "Cor da van", example = "Branco")
    private String cor;

    @Column(nullable = false)
    @Schema(description = "Preço da van em reais", example = "250000.00")
    private Double preco;

    @Column(nullable = false, unique = true)
    @Schema(description = "Placa no formato Mercosul (ABC1D23) ou antigo (ABC1234)", example = "ABC1D23")
    private String placa;

    @Column(nullable = false)
    @Schema(description = "Capacidade máxima de passageiros (1 a 30)", example = "15")
    private Integer capacidadePassageiros;

    @Column(nullable = false)
    @Schema(description = "Indica se a van é adaptada para Pessoas com Deficiência (PCD)", example = "false")
    private Boolean adaptadaPCD;

}