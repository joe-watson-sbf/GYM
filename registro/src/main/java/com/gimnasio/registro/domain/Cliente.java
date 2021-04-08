package com.gimnasio.registro.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "clientes")
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

}
