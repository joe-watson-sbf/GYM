package com.gimnasio.registro.service;

import com.gimnasio.registro.domain.Cliente;
import com.gimnasio.registro.domain.dto.ClienteDTO;
import com.gimnasio.registro.domain.exceptions.BusinessException;
import com.gimnasio.registro.repository.ClienteRepo;
import com.gimnasio.registro.util.Respuesta;
import com.gimnasio.registro.util.Validate;
import com.gimnasio.registro.util.factory.ClienteFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private static String CLIENTE_NO_ENCONTRADO = "Cliente no encontrado";
    private static String CLIENTE_NO_REGISTRADO = "Se ocurre un error al registrar el cliente, revisar los datos y intente de nuevo!";
    private static String CLIENTE_REGISTRADO = "Se ha registrado exitosamente!!!";
    private static String CLIENTE_NO_ELIMINADO = "No se puede eliminar el cliente, verifique el numero de cedula por favor!!!";
    private static String CLIENTE_ELIMINADO = "Elimanado exitosamente";




    @Autowired
    ClienteRepo clienteRepo;
    @Autowired
    ClienteFactory factory;


    @Override
    public Respuesta agregar(ClienteDTO clienteDTO) throws Exception {
        clienteDTO = Validate.validarDTO(clienteDTO);
        try {
            clienteRepo.save(factory.dtoToCliente(clienteDTO));
            return new Respuesta(CLIENTE_REGISTRADO);
        }catch (Exception ex){
            throw new BusinessException(CLIENTE_NO_REGISTRADO);
        }
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
    public ClienteDTO obtenerPorCedula(Long cedula) {
        try {
            return factory.clienteToDto(clienteRepo.getOne(cedula));
        }catch (Exception ex){
            throw new BusinessException(CLIENTE_NO_ENCONTRADO);
        }

    }


    @Override
    public List<Cliente> obtenerClientes() {
        return clienteRepo.findAll();
    }
}
