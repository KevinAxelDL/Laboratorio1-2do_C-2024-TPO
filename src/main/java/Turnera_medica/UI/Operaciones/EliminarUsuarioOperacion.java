/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Operaciones;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Servicios.AdministradorServicios;
import Turnera_medica.UI.Mediadores.AdministradorFrames;

/**
 *
 * @author KevinDL
 */

public class EliminarUsuarioOperacion extends OperacionSobreUsuario{
    
    public EliminarUsuarioOperacion(String usuario){
        super(usuario);
    }
    
    public EliminarUsuarioOperacion(){
    }
    
    @Override
    public Object realizar() throws OperacionException {
        int resultado;
        try {
            resultado = AdministradorServicios.eliminarUsuario(this.usuario);
            AdministradorFrames.mostrarMensaje("Operacion exitosa, registros afectados: "+ resultado);
        } catch (ServicioException ex) {
            throw new OperacionException(ex.getMessage());
        }
        return null;
    }
    
    @Override
    public void setUsuario(String usuario) {
        super.setUsuario(usuario);
    }
}
