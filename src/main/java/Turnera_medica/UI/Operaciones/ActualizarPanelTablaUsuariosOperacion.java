/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Operaciones;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.UI.Paneles.PanelTablaUsuariosUI;

/**
 *
 * @author KevinDL
 */

@Deprecated
public class ActualizarPanelTablaUsuariosOperacion extends Operacion{
    private PanelTablaUsuariosUI panel;
    
    public ActualizarPanelTablaUsuariosOperacion(PanelTablaUsuariosUI panel){
        this.panel = panel;
    }
        
    @Override
    public Object realizar() throws OperacionException {
        //Obtencion de datos
        this.panel.actualizar();
        return null;
    }
    
}
