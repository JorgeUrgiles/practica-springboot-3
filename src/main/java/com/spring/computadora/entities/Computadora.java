package com.spring.computadora.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_computadoras")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max=50)
    @NotBlank
    private String marca;
    @NotBlank
    private String modelo;
    @NotBlank
    private String procesadorMarca;
    @NotBlank
    private String procesadorVelocidad;
    @NotBlank
    private String procesadorGeneracion;
    @NotBlank
    private String ramTipo;
    @NotBlank
    private String ramCapacidad;
    @NotBlank
    private String discoDuroTipo;
    @NotBlank
    private String discoDuroCapacidad;
    @NotBlank
    private String GraficaMarca;
    @NotBlank
    private String GraficaCapacidad;



}
