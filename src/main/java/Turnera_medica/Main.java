/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica;

import Turnera_medica.UI.Paneles.PanelTablaUsuariosUI;
import Turnera_medica.UI.Incompleto.ReportesAdministradorUI;
import Turnera_medica.UI.Frames.IngresoCredencialesUI;



/**
 *
 * @author KevinDL
 */

public class Main {
    public static void main(String[] args) {
        ReportesAdministradorUI dev = new ReportesAdministradorUI();
        dev.armar();
        //
        IngresoCredencialesUI credencialesUI = new IngresoCredencialesUI();
        credencialesUI.armar();
        // NOTA: Se debe ejecutar primero el .jar de la BD para que funcione la aplicacion
    }
}
