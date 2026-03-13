package com.ctw.strelow.car_management_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Van {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String ano;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private Integer capacidadePassageiros;

    @Column(nullable = false)
    private Boolean adaptadaPCD;

}