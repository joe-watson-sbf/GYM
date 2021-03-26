package com.gimnasio.registro.service;

import com.gimnasio.registro.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {
    boolean agregar(Cliente cliente);
    boolean eliminar(Cliente cliente);
    Cliente obtenerPorCodigo(Long codigo);
    Cliente obtenerPorId(String id);
    List<Cliente> obtenerClientes();
}
