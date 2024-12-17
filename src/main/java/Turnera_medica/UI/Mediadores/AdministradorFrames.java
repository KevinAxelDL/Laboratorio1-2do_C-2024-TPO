/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Mediadores;

import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Modelo.Medico;
import Turnera_medica.Modelo.Paciente;
import Turnera_medica.Modelo.Usuario;
import Turnera_medica.UI.Frames.FormularioTurnoUI;
import Turnera_medica.UI.Frames.FormularioUsuarioUI;
import Turnera_medica.UI.Frames.IngresoCredencialesUI;
import Turnera_medica.UI.Frames.IngresoNombreUsuarioUI;
import Turnera_medica.UI.Frames.MensajeUI;
import Turnera_medica.UI.Frames.MenuAdministradorUI;
import Turnera_medica.UI.Frames.MenuMedicoUI;
import Turnera_medica.UI.Frames.ReportesAdministradorUI;
import Turnera_medica.UI.Frames.UserInterface;
/**
 *
 * @author KevinDL
 */
public abstract class AdministradorFrames {
    private static MensajeUI ultimoMensaje;
    
    public static void mostrarMenu(Usuario usuario){
        // Abre menu de administrador
        if(usuario instanceof Administrador){
            MenuAdministradorUI menu = new MenuAdministradorUI((Administrador) usuario);
            menu.armar();
        }
       
        if(usuario instanceof Medico){
            MenuMedicoUI menu = new MenuMedicoUI((Medico)usuario);
            menu.armar();
        }
        
        if(usuario instanceof Paciente){
            //IMPLEMENTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAR
        }
        
    }
    
    public static void mostrarIngresoCredenciales(){
        // Abre
        IngresoCredencialesUI ui = new IngresoCredencialesUI();
        ui.armar();
    }
    
    public static void mostrarFormularioNuevoUsuario(){
        // Accion del boton
        FormularioUsuarioUI ui = new FormularioUsuarioUI();
        ui.armar();
    }
    
    public static void mostrarIngresoNombreUsuario(String texto){
        IngresoNombreUsuarioUI ui = new IngresoNombreUsuarioUI(texto);
        ui.armar();
    }
    
    public static void cerrarUI(UserInterface ui){ // ui es una instancia que implementa UserInterface
        // Cierra cualquier instancia de UserInterface
        ui.cerrar();
    }
    
    public static void mostrarMensaje(String texto){
        MensajeUI mensaje = new MensajeUI(texto);
        if(ultimoMensaje != null){
            ultimoMensaje.cerrar();
        }
        ultimoMensaje = mensaje;
        mensaje.armar();
    }
    
    public static void mostrarMenuReportesAdministrador(){
        ReportesAdministradorUI ui = new ReportesAdministradorUI();
        ui.armar();
    }
    
    public static void mostrarFormularioNuevoTurno(){
        FormularioTurnoUI ui = new FormularioTurnoUI();
        ui.armar();
    }
}
