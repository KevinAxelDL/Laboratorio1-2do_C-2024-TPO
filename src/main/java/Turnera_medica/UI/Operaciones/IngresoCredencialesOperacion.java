/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Operaciones;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Modelo.Medico;
import Turnera_medica.Modelo.Paciente;
import Turnera_medica.Modelo.Usuario;
import Turnera_medica.Servicios.UsuarioServicios;
import Turnera_medica.UI.Mediadores.AdministradorFrames;

/**
 *
 * @author KevinDL
 */

@Deprecated
public class IngresoCredencialesOperacion extends Operacion{
    // Operacion para el ingreso al sistema como un usuario
    private String usuario;
    private String clave;
    private Class<?> tipoUsuario;
    
    public IngresoCredencialesOperacion(String usuario, String clave, Class<?> tipoUsuario){
        this.usuario = usuario;
        this.clave = clave;
        this.tipoUsuario = tipoUsuario;
    }
    
    @Override
    public Object realizar() throws OperacionException{
        // Manda a verificar los datos y pide que se muestre un nuevo menu
        Usuario usuarioRetornado = null;
        try {
            usuarioRetornado = UsuarioServicios.ingresarComoUsuario(this.usuario, this.clave, this.tipoUsuario); // Llamada a metodo de clase
        } catch (ServicioException ex) {
            throw new OperacionException(ex.getMessage());
        }
        
        AdministradorFrames.mostrarMenu(usuarioRetornado); // Indica que se debe mostrar un menu nuevo
        
        return null;
    }
    
    
}
