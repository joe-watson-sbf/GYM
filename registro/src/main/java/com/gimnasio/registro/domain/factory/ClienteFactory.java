package com.gimnasio.registro.domain.factory;

import com.gimnasio.registro.domain.dto.ClienteDTO;
import com.gimnasio.registro.domain.Cliente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteFactory {

    public List<ClienteDTO> clienteToDto(List<Cliente> clienteList){
        List<ClienteDTO> clienteDTOS = new ArrayList<>();
        clienteList.forEach(cliente -> {
            clienteDTOS.add(clienteToDto(cliente));
        });
        return clienteDTOS;
    }

    public ClienteDTO clienteToDto(Cliente cliente){
        ClienteDTO dto = new ClienteDTO();

        dto.setCedula(cliente.getCedula());
        dto.setNombre(cliente.getNombre());
        dto.setApellidos(cliente.getApellidos());
        dto.setAltura(cliente.getAltura());
        dto.setCelular(cliente.getCelular());
        dto.setDia_vigencia(cliente.getDia_vigencia());
        dto.setMensualidad(cliente.getMensualidad());
        dto.setModalidad(cliente.getModalidad());
        dto.setPeso(cliente.getPeso());
        dto.setTipo_sangre(cliente.getTipo_sangre());
        dto.setEps(cliente.getEps());

        return dto;
    }

    public Cliente dtoToCliente(ClienteDTO dto){
        Cliente cliente = new Cliente();

        cliente.setCedula(dto.getCedula());
        cliente.setApellidos(dto.getApellidos());
        cliente.setNombre(dto.getNombre());
        cliente.setAltura(dto.getAltura());
        cliente.setCelular(dto.getCelular());
        cliente.setMensualidad(dto.getMensualidad());
        cliente.setModalidad(dto.getModalidad());
        cliente.setPeso(dto.getPeso());
        cliente.setDia_vigencia(dto.getDia_vigencia());
        cliente.setTipo_sangre(dto.getTipo_sangre());
        cliente.setEps(dto.getEps());

        return cliente;
    }



}
