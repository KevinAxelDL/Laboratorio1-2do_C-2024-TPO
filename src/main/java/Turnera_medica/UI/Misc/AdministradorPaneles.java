/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Misc;

import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Modelo.Usuario;
import Turnera_medica.UI.FormularioUsuarioUI;
import Turnera_medica.UI.IngresoCredencialesUI;
import Turnera_medica.UI.MensajeUI;
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
    
    public static void mostrarFormularioNuevoUsuario(){
        // Accion del boton
        FormularioUsuarioUI formulario = new FormularioUsuarioUI();
        formulario.armar();
    }
    
    public static void cerrarUI(UserInterface ui){ // ui es una instancia que implementa UserInterface
        // Cierra cualquier instancia de UserInterface
        ui.cerrar();
    }
    
    public static void mostrarMensaje(String texto){
        MensajeUI mensaje = new MensajeUI(texto);
        mensaje.mostrar();
    }
}
