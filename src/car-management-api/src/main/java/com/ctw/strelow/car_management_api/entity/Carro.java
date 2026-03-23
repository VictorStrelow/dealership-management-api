package com.ctw.strelow.car_management_api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entidade que representa um carro cadastrado na concessionária")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do carro", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Marca do carro", example = "Toyota")
    private String marca;

    @Column(nullable = false)
    @Schema(description = "Modelo do carro", example = "Hilux")
    private String modelo;

    @Column(nullable = false)
    @Schema(description = "Ano de fabricação do carro (4 dígitos)", example = "2022")
    private String ano;

    @Column(nullable = false)
    @Schema(description = "Cor do carro", example = "Prata")
    private String cor;

    @Column(nullable = false)
    @Schema(description = "Preço do carro em reais", example = "129890.00")
    private Double preco;

    @Column(nullable = false, unique = true)
    @Schema(description = "Placa no formato Mercosul (ABC1D23) ou antigo (ABC1234)", example = "ABC1D23")
    private String placa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Schema(description = "Tipo de combustível do carro",
            allowableValues = {"GASOLINE", "ETHANOL", "FLEX", "DIESEL", "ELECTRIC", "HYBRID"},
            example = "FLEX")
    private tipoCombustivel tipoCombustivel;

    public enum tipoCombustivel {
        GASOLINE,
        ETHANOL,
        FLEX,
        DIESEL,
        ELECTRIC,
        HYBRID
    }

}