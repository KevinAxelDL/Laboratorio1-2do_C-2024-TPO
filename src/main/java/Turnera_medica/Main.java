/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica;

import Turnera_medica.Modelo.Administrador;
import Turnera_medica.UI.Paneles.PanelTablaUsuariosUI;
import Turnera_medica.UI.Frames.ReportesAdministradorUI;
import Turnera_medica.UI.Frames.IngresoCredencialesUI;
import Turnera_medica.UI.Incompleto.IngresoFecha;
import Turnera_medica.UI.Incompleto.IngresoHorasUI;



/**
 *
 * @author KevinDL
 */

public class Main {
    public static void main(String[] args) {
        //
        IngresoCredencialesUI credencialesUI = new IngresoCredencialesUI();
        credencialesUI.armar();
        // NOTA: Se debe ejecutar primero el .jar de la BD para que funcione la aplicacion
    }
}
