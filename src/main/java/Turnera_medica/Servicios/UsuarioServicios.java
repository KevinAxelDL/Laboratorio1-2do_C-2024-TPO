/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.Servicios;

import Turnera_medica.DAO.UsuarioDAOH2;
import Turnera_medica.Excepciones.DAOException;
import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Modelo.Usuario;

/**
 *
 * @author KevinDL
 */
public class UsuarioServicios {
    
    // Metodos de clase
    public static Usuario ingresarComoUsuario(String nombreUsuario, String claveUsuario, Class<?> tipoClase) throws ServicioException{
        UsuarioDAOH2 userH2 = new UsuarioDAOH2();
        Usuario usuario = null;
        try {
            usuario = userH2.ingresarComoUsuario(nombreUsuario, claveUsuario, tipoClase);
        } catch (DAOException ex) {
            throw new ServicioException(ex.getMessage());
        }
        return usuario;
    }  
    
    // Verificacion de datos
    public void verificarDatoClave (String dato) throws ServicioException{
        if(dato.isBlank() || dato.isEmpty()){
            throw new ServicioException("CLAVE NO VALIDA!");
        }
    };
    
    public void verificarDatoUsuario (String dato) throws ServicioException{
        if(dato.isBlank() || dato.isEmpty()){
            throw new ServicioException("NOMBRE DE USUARIO NO VALIDO!");
        }
    };
        
    
    public void verificarDatoDNI(String dato) throws ServicioException{
        if(dato.isBlank() || dato.isEmpty()){
            throw new ServicioException("DNI NO VALIDO!");
        }else{
            try {
                Integer.parseInt(dato); // Los caracteres deben ser numeros
            } catch (NumberFormatException e) {
                throw new ServicioException("DNI NO VALIDO!");
            }
        } 
    }
    
    public void verificarDatoNombreApellido(String dato) throws ServicioException{
        if(dato.isBlank()|| dato.isEmpty() || dato.matches(".*\\d.*") || dato.matches(".*[^a-zA-Z0-9].*")){
            throw new ServicioException("NOMBRE/APELLIDO NO VALIDO!");
        }
    };
    
    public void verificarDatoTipoUsuario(Object[] datos) throws ServicioException{
        boolean datosNoValidos = true;
        for(int i = 0; i < datos.length; i++){
            if(datos[i] != null){
                // Con que exista un solo tipo de dato del modelo, es opcion valida
                datosNoValidos = false;
            }
        }
        
        if(datosNoValidos == true){
            throw new ServicioException("INGRESE UN TIPO DE USUARIO VALIDO!");
        } 
        
    };

}
