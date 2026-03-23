package com.ctw.strelow.car_management_api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "motos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entidade que representa uma moto cadastrada na concessionária")
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único da moto", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Marca da moto", example = "Honda")
    private String marca;

    @Column(nullable = false)
    @Schema(description = "Modelo da moto", example = "Hornet")
    private String modelo;

    @Column(nullable = false)
    @Schema(description = "Ano de fabricação da moto (4 dígitos)", example = "2023")
    private String ano;

    @Column(nullable = false)
    @Schema(description = "Cor da moto", example = "Vermelho")
    private String cor;

    @Column(nullable = false)
    @Schema(description = "Preço da moto em reais", example = "32500.00")
    private Double preco;

    @Column(nullable = false, unique = true)
    @Schema(description = "Placa no formato Mercosul (ABC1D23) ou antigo (ABC1234)", example = "ABC1D23")
    private String placa;

    @Column(nullable = false)
    @Schema(description = "Cilindradas do motor em cc", example = "500")
    private Integer cilindradas;

}