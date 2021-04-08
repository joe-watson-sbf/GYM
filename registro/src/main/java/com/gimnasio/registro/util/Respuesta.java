package com.gimnasio.registro.util;

import lombok.Data;

@Data
public class Respuesta {
    private String respuesta;

    public Respuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
