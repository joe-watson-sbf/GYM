package com.gimnasio.registro.util;

import com.gimnasio.registro.domain.dto.ClienteDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateTest {


    ClienteDTO inicio(){
        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setCedula(12234L);
        clienteDTO.setNombre("Usuario");
        clienteDTO.setApellidos("Usuario");
        clienteDTO.setEps("SURA");
        clienteDTO.setAltura(23);
        clienteDTO.setCelular("+573004008978");
        clienteDTO.setDia_vigencia(15);
        clienteDTO.setMensualidad(50000);
        clienteDTO.setModalidad("Mensual");
        clienteDTO.setTipo_sangre("o+");
        clienteDTO.setPeso(60);

        return clienteDTO;
    }

    @Test
    void tipoDeSangreAceptado(){
        ClienteDTO cliente = inicio();
        cliente.setTipo_sangre("a+");
        String tipo_sangre = Validate.definirTipoSangre(cliente.getTipo_sangre());


        assertEquals(tipo_sangre, "A+");
    }

    @Test
    void DTOaceptado(){
        ClienteDTO cliente = inicio();

        assertEquals(Validate.validarDTO(cliente), cliente);
    }



}
