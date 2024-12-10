/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Operaciones;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Servicios.AdministradorServicios;

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
    private Class<?> opcionSeleccionada;
    
    public CrearNuevoUsuarioOperacion(String usuario, String clave, String nombre, String apellido, String dni, Class<?> opcionSeleccionada){
        this.usuario = usuario;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.opcionSeleccionada = opcionSeleccionada;
    }
    
    public CrearNuevoUsuarioOperacion(){
        
    }

    @Override
    public Object realizar() throws OperacionException {
        // Accion del boton
        //NOTA: DE MOMENTO SOLO SE PUEDE CREAR UN ADMINISTRADOR, UN SWITCH A FUTURO NO ES IDEAL PARA DETERMINAR QUE USARIO SE CREA
        AdministradorServicios servicios = new AdministradorServicios();
        
        try {
            servicios.verificarDatoClave(this.clave);
            servicios.verificarDatoUsuario(this.usuario);
            servicios.verificarDatoDNI(this.dni);
            servicios.verificarDatoNombreApellido(this.nombre);
            servicios.verificarDatoNombreApellido(this.apellido);
            servicios.verificarDatoTipoUsuario(opcionSeleccionada);
        } catch (ServicioException ex) {
            throw new OperacionException(ex.getMessage());
        }
        
        
        if(this.opcionSeleccionada == Administrador.class){
            crearAdministrador();
        }
        /*
        if(this.opcionSeleccionada == Medico.class){
            //crearMedico();
        }
        
        if(this.opcionSeleccionada == Paciente.class){
            //crearPaciente();
        }
        */
        return null;
    }
    
    private void crearAdministrador() throws OperacionException{
        int dniComoInt;
        
        try {
            dniComoInt = Integer.parseInt(dni); // Los caracteres deben ser numeros
            Administrador nuevoAdmin = new Administrador(dniComoInt,  this.nombre,  this.apellido, this.usuario, this.clave); // Instancia del modelo
            AdministradorServicios.registrarAdministrador(nuevoAdmin);
            
        } catch (ServicioException ex) {
            throw new OperacionException(ex.getMessage());
        }
    }
    
    //private void crearMedico() throws OperacionException{}
    
    //private void crearPaciente() throws OperacionException{}
    
}
