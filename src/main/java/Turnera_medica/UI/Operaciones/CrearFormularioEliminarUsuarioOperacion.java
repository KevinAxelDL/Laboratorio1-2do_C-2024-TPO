/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Operaciones;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.UI.Mediadores.AdministradorFrames;

/**
 *
 * @author KevinDL
 */
public class CrearFormularioEliminarUsuarioOperacion implements Operacion{

    @Override
    public Object realizar() throws OperacionException {
        AdministradorFrames.mostrarIngresoNombreUsuario("Eliminar usuario");
        return null;
    }
    
}
