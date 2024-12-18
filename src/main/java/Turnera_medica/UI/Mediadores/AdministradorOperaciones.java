/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Mediadores;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Modelo.Usuario;
import Turnera_medica.Servicios.AdministradorServicios;
import Turnera_medica.Servicios.UsuarioServicios;
import java.util.List;


/**
 *
 * @author KevinDL
 */
public abstract class AdministradorOperaciones {
    
    public static void ingresarCredenciales(String usuario, String clave,Class<?> tipoUsuario) throws OperacionException{
        // Manda a verificar los datos y pide que se muestre un nuevo menu
        Usuario usuarioRetornado = null;
        try {
            usuarioRetornado = UsuarioServicios.ingresarComoUsuario(usuario, clave, tipoUsuario); // Llamada a metodo de clase
        } catch (ServicioException ex) {
            throw new OperacionException(ex.getMessage());
        }

        AdministradorFrames.mostrarMenu(usuarioRetornado); // Indica que se debe mostrar un menu nuevo
    }
    
    public static int eliminarUsuario(String usuario) throws OperacionException {
        int resultado;
        try {
            resultado = AdministradorServicios.eliminarUsuario(usuario);
        } catch (ServicioException ex) {
            throw new OperacionException(ex.getMessage());
        }
        return resultado;
    }
    
    public static void registrarNuevoUsuario(String usuario, String clave, String nombre, 
            String apellido, String dni, List<Class<?>> opcionesUsuario) throws OperacionException {
        // Accion del boton
        AdministradorServicios servicios = new AdministradorServicios();
        
        try {
            //Verifica que los campos sean correctos
            servicios.verificarDatoClave(clave);
            servicios.verificarDatoUsuario(usuario);
            servicios.verificarDatoDNI(dni);
            servicios.verificarDatoNombreApellido(nombre);
            servicios.verificarDatoNombreApellido(apellido);
            
            Object[] opcionesComoArray = opcionesUsuario.toArray();
            
            servicios.verificarDatoTipoUsuario(opcionesComoArray);

            
        } catch (ServicioException ex) {
            throw new OperacionException(ex.getMessage());
        }
        
        int dniComoInt;
        
        try {
            dniComoInt = Integer.parseInt(dni); // Los caracteres deben ser numeros
            Usuario nuevoUsuario = new Usuario(dniComoInt, nombre, apellido, usuario, clave); // Instancia del modelo
            AdministradorServicios.registrarUsuario(nuevoUsuario, opcionesUsuario);
            
        } catch (ServicioException ex) {
            throw new OperacionException(ex.getMessage());
        }
    }
    
    public static void registrarNuevoTurno(String medico, String paciente, String fechaYHora, String consultorio) throws OperacionException{
        try {
            AdministradorServicios.registrarTurno(medico, paciente, fechaYHora, consultorio);
        } catch (ServicioException ex) {
            throw new OperacionException(ex.getMessage());
        }
    }
}
