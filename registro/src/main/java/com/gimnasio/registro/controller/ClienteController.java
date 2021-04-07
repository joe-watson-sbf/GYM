package com.gimnasio.registro.controller;

import com.gimnasio.registro.model.Cliente;
import com.gimnasio.registro.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("usuario/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/todo")
    public List<Cliente> clientes(){
        return clienteService.obtenerClientes();
    }


}
