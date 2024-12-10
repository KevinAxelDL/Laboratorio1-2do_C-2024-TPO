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
public class EliminarUsuarioOperacion implements Operacion{
    private String usuario;
    
    public EliminarUsuarioOperacion(String usuario){
        this.usuario = usuario;
    }
    
    @Override
    public Object realizar() throws OperacionException {
        int resultado;
        try {
            resultado = AdministradorServicios.eliminarAdministrador(this.usuario);
            AdministradorFrames.mostrarMensaje("Operacion exitosa, registros afectados: "+ resultado);
        } catch (ServicioException ex) {
            throw new OperacionException(ex.getMessage());
        }
        return null;
    }
    
}
