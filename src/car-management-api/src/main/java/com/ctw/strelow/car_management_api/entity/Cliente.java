package com.ctw.strelow.car_management_api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entidade que representa um cliente cadastrado na concessionária")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do cliente", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Nome completo do cliente", example = "João da Silva")
    private String nome;

    @Column(nullable = false, unique = true)
    @Schema(description = "CPF do cliente no formato 000.000.000-00", example = "123.456.789-00")
    private String cpf;

    @Column(nullable = false, unique = true)
    @Schema(description = "Endereço de e-mail do cliente", example = "exemplo@email.com")
    private String email;

    @Column(nullable = false)
    @Schema(description = "Telefone no formato (00) 00000-0000 ou (00) 0000-0000", example = "(11) 99999-0000")
    private String telefone;

    @Column(nullable = false)
    @Schema(description = "Cidade de residência do cliente", example = "Jaraguá do Sul")
    private String cidade;

    @Column(nullable = false)
    @Schema(description = "Sigla do estado (UF) com 2 letras", example = "SC")
    private String estado;

}