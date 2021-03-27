package com.gimnasio.registro.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Cliente {
    @Id
    @Column(nullable = false, unique = true)
    private Long cedula;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellidos;
    private String celular;
    private String tipo_sangre;
    private double peso;
    private double altura;
    @Column(nullable = false)
    private int mensualidad;
    @Column(nullable = false)
    private String modalidad;
    @Column(nullable = false)
    private int dia_vigencia;



    /*

    REQUISITOS DE INFORMACIÓN CLIENTE
- Nombre
- Apellidos
- CC
- Celular
- RH

Peso
Estatura
requisitos mensualidad
Nombre del plan
dias de vigencia

  */


}
