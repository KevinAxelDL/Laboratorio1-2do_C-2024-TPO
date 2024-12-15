/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Operaciones;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Modelo.Usuario;
import Turnera_medica.Servicios.AdministradorServicios;
import java.util.List;

/**
 *
 * @author KevinDL
 */
public class CrearNuevoUsuarioOperacion implements Operacion{
    private String usuario;
    private String clave; 
    private String nombre; 
    private String apellido;
    private String dni; 
    private List<Class<?>> opcionesUsuario;
    
    public CrearNuevoUsuarioOperacion(String usuario, String clave, String nombre, 
            String apellido, String dni, List<Class<?>> opcionesUsuario){
        this.usuario = usuario;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.opcionesUsuario = opcionesUsuario;
    }

    @Override
    public Object realizar() throws OperacionException {
        // Accion del boton
        //NOTA: DE MOMENTO SOLO SE PUEDE CREAR UN ADMINISTRADOR, UN SWITCH A FUTURO NO ES IDEAL PARA DETERMINAR QUE USARIO SE CREA
        AdministradorServicios servicios = new AdministradorServicios();
        
        try {
            //Verifica que los campos sean correctos
            servicios.verificarDatoClave(this.clave);
            servicios.verificarDatoUsuario(this.usuario);
            servicios.verificarDatoDNI(this.dni);
            servicios.verificarDatoNombreApellido(this.nombre);
            servicios.verificarDatoNombreApellido(this.apellido);
            
            Object[] opcionesComoArray = this.opcionesUsuario.toArray();
            
            servicios.verificarDatoTipoUsuario(opcionesComoArray);

            
        } catch (ServicioException ex) {
            throw new OperacionException(ex.getMessage());
        }
        
        crearUsuario();
        
        return null;
    }
    
    private void crearUsuario() throws OperacionException{
        int dniComoInt;
        
        try {
            dniComoInt = Integer.parseInt(dni); // Los caracteres deben ser numeros
            Usuario nuevoUsuario = new Usuario(dniComoInt,  this.nombre,  this.apellido, this.usuario, this.clave); // Instancia del modelo
            AdministradorServicios.registrarUsuario(nuevoUsuario, this.opcionesUsuario);
            
        } catch (ServicioException ex) {
            throw new OperacionException(ex.getMessage());
        }
    }   
}
