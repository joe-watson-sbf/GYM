package com.gimnasio.registro.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {
    private Long cedula;
    private String nombre;
    private String apellidos;
    private String celular;
    private String tipo_sangre;
    private double peso;
    private double altura;
    private int mensualidad;
    private String modalidad;
    private int dia_vigencia;
    private String eps;
}
