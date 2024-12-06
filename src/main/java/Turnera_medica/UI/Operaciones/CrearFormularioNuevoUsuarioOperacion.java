/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Operaciones;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.UI.Misc.AdministradorPaneles;

/**
 *
 * @author KevinDL
 */
public class CrearFormularioNuevoUsuarioOperacion implements Operacion{

    @Override
    public Object realizar() throws OperacionException {
        // Accion del boton
        AdministradorPaneles.mostrarFormularioNuevoUsuario();
        return null;
    }
    
}