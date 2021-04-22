package com.gimnasio.registro.controller;

import com.gimnasio.registro.domain.dto.ClienteDTO;
import com.gimnasio.registro.domain.exceptions.BusinessException;
import com.gimnasio.registro.domain.service.ClienteService;
import com.gimnasio.registro.util.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/gimnasio/")
//@CrossOrigin(origins="http://127.0.0.1:5500")http:
@CrossOrigin(origins="http://localhost:4200/localhost:4200")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ClienteDTO model(){
        return new ClienteDTO();
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteDTO>> clientes(){
        return new ResponseEntity<>(clienteService.obtenerClientes(), HttpStatus.OK);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(clienteService.obtenerPorCedula(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity<>(new Respuesta(e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/cliente")
    public ResponseEntity<Respuesta> addCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            return new ResponseEntity<>(clienteService.agregar(clienteDTO), HttpStatus.CREATED);
        }catch (BusinessException ex){
            return new ResponseEntity<>(new Respuesta(ex.getMessage()), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("cliente/{cedula}")
    public ResponseEntity<Respuesta> deleteCliente(@PathVariable Long cedula){
        try {
            return new ResponseEntity<>(clienteService.eliminarPorId(cedula), HttpStatus.OK);
        }catch (BusinessException ex){
            return new ResponseEntity<>(new Respuesta(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/cliente")
    public ResponseEntity<Respuesta> actualizarDatos(@RequestBody ClienteDTO clienteDTO){
        try {
            return new ResponseEntity<>(clienteService.actualizar(clienteDTO), HttpStatus.OK);
        }catch (BusinessException ex){
            return new ResponseEntity<>(new Respuesta(ex.getMessage()), HttpStatus.NOT_MODIFIED);
        }
    }
}
