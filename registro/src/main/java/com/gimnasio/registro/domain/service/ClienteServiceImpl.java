package com.gimnasio.registro.domain.service;

import com.gimnasio.registro.domain.Cliente;
import com.gimnasio.registro.domain.dto.ClienteDTO;
import com.gimnasio.registro.domain.exceptions.BusinessException;
import com.gimnasio.registro.domain.repository.ClienteRepo;
import com.gimnasio.registro.util.Respuesta;
import com.gimnasio.registro.util.Validate;
import com.gimnasio.registro.domain.factory.ClienteFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private static String CLIENTE_NO_ENCONTRADO = "Cliente no encontrado";
    private static String DATOS_CLIENTE_ACTUALIZADO = "Se ha actualizado exitosamente!!!";
    private static String CLIENTE_REGISTRADO = "Se ha registrado exitosamente!!!";
    private static String CLIENTE_NO_ELIMINADO = "No se puede eliminar el cliente, verifique el numero de cedula por favor!!!";
    private static String CLIENTE_ELIMINADO = "Elimanado exitosamente";




    @Autowired
    ClienteRepo clienteRepo;
    @Autowired
    ClienteFactory factory;


    @Override
    public Respuesta agregar(ClienteDTO clienteDTO) {
        clienteRepo.save(factory.dtoToCliente(Validate.validarDTO(clienteDTO)));
        return new Respuesta(CLIENTE_REGISTRADO);
    }

    @Override
    public Respuesta actualizar(ClienteDTO clienteDTO) {
        boolean exist = clienteRepo.existsById(clienteDTO.getCedula());
        if (exist) agregar(clienteDTO);
        return new Respuesta(DATOS_CLIENTE_ACTUALIZADO);
    }

    @Override
    public Respuesta eliminar(ClienteDTO clienteDTO) {
        try {
            clienteRepo.delete(factory.dtoToCliente(clienteDTO));
            return new Respuesta(CLIENTE_ELIMINADO);
        }catch (Exception ex){
            throw new BusinessException(CLIENTE_NO_ELIMINADO);
        }
    }

    @Override
    public Respuesta eliminarPorId(Long cedula) {
        try {
            clienteRepo.deleteById(cedula);
            return new Respuesta(CLIENTE_ELIMINADO);
        }catch (Exception ex){
            throw new BusinessException(CLIENTE_NO_ELIMINADO);
        }
    }

    @Override
    public ClienteDTO obtenerPorCedula(Long cedula) {
        try {
            return factory.clienteToDto(clienteRepo.getOne(cedula));
        }catch (Exception ex){
            throw new BusinessException(CLIENTE_NO_ENCONTRADO);
        }

    }


    @Override
    public List<ClienteDTO> obtenerClientes() {
        return factory.clienteToDto(clienteRepo.findAll());
    }
}
