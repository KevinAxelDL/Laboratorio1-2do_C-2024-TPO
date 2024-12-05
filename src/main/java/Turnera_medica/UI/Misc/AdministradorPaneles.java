/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Misc;

import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Modelo.Usuario;
import Turnera_medica.UI.IngresoCredencialesUI;
import Turnera_medica.UI.MenuAdministradorUI;
import Turnera_medica.UI.UserInterface;

/**
 *
 * @author KevinDL
 */
public abstract class AdministradorPaneles {
    
    public static void mostrarMenu(Usuario usuario){
        // Abre menu de administrador
        if(usuario instanceof Administrador){
            MenuAdministradorUI menu = new MenuAdministradorUI((Administrador) usuario);
            menu.armar();
        }
        
        /*
        if(usuario instanceof Medico){
            MenuMedicoUI menu = new MenuMedicoUI((Medico) usuario);
            menu.armar();
        }
        */
        
    }
    
    public static void mostrarIngresoCredenciales(){
        // Abre
        IngresoCredencialesUI menu = new IngresoCredencialesUI();
        menu.armar();
    }
    
    public static void cerrarUI(UserInterface ui){
        // Cierra cualquier instancia de UserInterface
        ui.cerrar();
    }
}
