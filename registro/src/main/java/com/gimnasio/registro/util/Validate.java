package com.gimnasio.registro.util;

import com.gimnasio.registro.domain.dto.ClienteDTO;
import com.gimnasio.registro.domain.exceptions.BusinessException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static String TIPOSDESANGRES = "A-A+O+O-B+B-AB+AB-";
    private static String MODALIDAD_REQUERIDO = "No puedes registrar sin elegir una modalidad!";
    private static String CEDULA_NO_ACEPTADO = "Ingrese un numero de cedula valido!";
    private static String APELLIDO_VACIO = "Su apellido no puede ser vacio!";
    private static String NOMBRE_VACIO = "Su numbre no puede ser vacio!";
    private static String DIA_VIGENCIA_NO_ACEPTADO = "El día vigencia debe ser mayor o igual a 1!";
    private static String MENSUALIDAD_NO_ACEPTADO = "La mensualidad no puede ser menor que 1!";
    private static String CONTRESENA_INVALIDA="Su contresaña debe contener solo numero o digito!!!";
    private static String LONGITUD_CONTRASENA_INVALIDA = "La contraseña debe tener al menos 8 caracteres!!!";
    private static String NUMERO_CELULAR_INVALIDO = "El numero de celular debe tener minimo 10 cararcteres si no incluye el codigo del marcado, de lo contrario 13.";
    private static String NUMERO_MARCADOR = "Numero marcador del pais requerido!";
    private static String EPS_VACIO = "Campo EPS vacío!!!";


    private static String unSoloEspacio(String cadena) {
        String regex = "\\s{2,}";
        Pattern patron = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher validador = patron.matcher(cadena);

        return validador.replaceAll(" ").trim();
    }


    private static String quitarEspacios(String cadena) {
        String regex = "\\s+";
        Pattern patron = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher validador = patron.matcher(cadena);
        return validador.replaceAll("").trim();
    }


    public static String definirTipoSangre(String tipo){
        tipo = Validate.quitarEspacios(tipo.toUpperCase());
        if (TIPOSDESANGRES.contains(tipo)){
            return tipo;
        }else {
            return null;
        }
    }


    public static void validarNumeroCelular(String celular){
        if(celular.startsWith("+57")){
            if(!(celular.length()==13)){
                throw new BusinessException(NUMERO_CELULAR_INVALIDO);
            }
        }
        if(!celular.startsWith("+")){
            throw new BusinessException(NUMERO_MARCADOR);
        }
        if(!(celular.length()>=10 && celular.length()<=13)){
            throw new BusinessException(NUMERO_CELULAR_INVALIDO);
        }
    }

    public static void validarEPS(String eps){
        if(eps.isBlank()) throw new BusinessException(EPS_VACIO);
    }

    public static String definirModalidad(String modalidad){
        modalidad = Validate.quitarEspacios(modalidad.toUpperCase());
        switch (modalidad){
            case "MENSUAL":
                return "MENSUAL";
            case "TIQUETERA":
                return "TIQUETERA";
            case "CLASE":
                return "CLASE";
            default:
                throw new BusinessException(MODALIDAD_REQUERIDO);
        }
    }

    public static ClienteDTO validarDTO(ClienteDTO clienteDTO){
        clienteDTO.setTipo_sangre(definirTipoSangre(clienteDTO.getTipo_sangre()));
        clienteDTO.setModalidad(definirModalidad(clienteDTO.getModalidad()));
        validarNumeroCelular(clienteDTO.getCelular());
        clienteDTO.setCelular(quitarEspacios(clienteDTO.getCelular()));
        validarEPS(clienteDTO.getEps());

        if(clienteDTO.getApellidos().isEmpty() || clienteDTO.getApellidos().isBlank() || clienteDTO.getApellidos() == null){
            throw new BusinessException(APELLIDO_VACIO);
        }
        if(clienteDTO.getNombre().isEmpty() || clienteDTO.getNombre().isBlank() || clienteDTO.getNombre() == null){
            throw new BusinessException(NOMBRE_VACIO);
        }
        clienteDTO.setApellidos(unSoloEspacio(clienteDTO.getApellidos()));
        clienteDTO.setNombre(unSoloEspacio(clienteDTO.getNombre()));

        if(clienteDTO.getDia_vigencia()<1){
            throw new BusinessException(DIA_VIGENCIA_NO_ACEPTADO);
        }
        if(clienteDTO.getMensualidad()<1){
            throw new BusinessException(MENSUALIDAD_NO_ACEPTADO);
        }
        if(clienteDTO.getCedula().toString().length()<6){
            throw new BusinessException(CEDULA_NO_ACEPTADO);
        }


        return clienteDTO;
    }
}
