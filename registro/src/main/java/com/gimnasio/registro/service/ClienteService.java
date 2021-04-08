package com.gimnasio.registro.service;

import com.gimnasio.registro.domain.Cliente;
import com.gimnasio.registro.domain.dto.ClienteDTO;
import com.gimnasio.registro.util.Respuesta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {
    Respuesta agregar(ClienteDTO clienteDTO) throws Exception;
    Respuesta eliminar(ClienteDTO clienteDTO);
    ClienteDTO obtenerPorCedula(Long cedula);
    List<Cliente> obtenerClientes();
}
