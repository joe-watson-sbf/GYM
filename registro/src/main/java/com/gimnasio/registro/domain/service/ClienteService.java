package com.gimnasio.registro.domain.service;


import com.gimnasio.registro.domain.dto.ClienteDTO;
import com.gimnasio.registro.util.Respuesta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {
    Respuesta agregar(ClienteDTO clienteDTO);
    Respuesta actualizar(ClienteDTO clienteDTO);
    Respuesta eliminar(ClienteDTO clienteDTO);
    Respuesta eliminarPorId(Long cedula);
    ClienteDTO obtenerPorCedula(Long cedula);
    List<ClienteDTO> obtenerClientes();


}
