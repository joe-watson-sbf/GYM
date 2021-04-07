package com.gimnasio.registro.service;

import com.gimnasio.registro.model.Cliente;
import com.gimnasio.registro.repository.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepo clienteRepo;

    @Override
    public boolean agregar(Cliente cliente) {
        return false;
    }

    @Override
    public boolean eliminar(Cliente cliente) {
        return false;
    }

    @Override
    public Cliente obtenerPorCedula(Long codigo) {
        return null;
    }


    @Override
    public List<Cliente> obtenerClientes() {
        return clienteRepo.findAll();
    }
}
