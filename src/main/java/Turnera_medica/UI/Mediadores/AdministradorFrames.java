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
import Turnera_medica.UI.Frames.MenuPacienteUI;
import Turnera_medica.UI.Frames.ReportesAdministradorUI;
import Turnera_medica.UI.Frames.ReportesMedicoUI;
import Turnera_medica.UI.Frames.ReportesPacienteUI;
import Turnera_medica.UI.Frames.UserInterface;
import Turnera_medica.UI.Operaciones.Operacion;
import Turnera_medica.UI.Operaciones.OperacionSobreUsuario;

/**
 *
 * @author KevinDL
 */
public abstract class AdministradorFrames {
    private static MensajeUI ultimoMensaje;
    private static UserInterface ultimoFrame1;
    private static UserInterface ultimoFrame2;
    private static UserInterface ultimoFrame3;
    private static UserInterface ultimoFrame4;
    private static UserInterface ultimoFrame5;
    
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
            MenuPacienteUI menu = new MenuPacienteUI((Paciente) usuario);
            menu.armar();
        }
        
    }
    
    public static void mostrarIngresoCredenciales(){
        // Abre
        IngresoCredencialesUI ui = new IngresoCredencialesUI();
        if(ultimoFrame1 != null){
            ultimoFrame1.cerrar();
        }
        ultimoFrame1 = ui;
        ui.armar();
    }
    
    public static void mostrarFormularioNuevoUsuario(){
        // Accion del boton
        FormularioUsuarioUI ui = new FormularioUsuarioUI();
        if(ultimoFrame2 != null){
            ultimoFrame2.cerrar();
        }
        ultimoFrame2 = ui;
        ui.armar();
    }
    
    public static void mostrarIngresoNombreUsuario(String texto, OperacionSobreUsuario operacion){
        IngresoNombreUsuarioUI ui = new IngresoNombreUsuarioUI(texto, operacion);
        if(ultimoFrame3 != null){
            ultimoFrame3.cerrar();
        }
        ultimoFrame3 = ui;
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
        if(ultimoFrame4 != null){
            ultimoFrame4.cerrar();
        }
        ultimoFrame4 = ui;
        ui.armar();
    }
    
    public static void mostrarMenuReportesMedico(Medico medico){
        ReportesMedicoUI ui = new ReportesMedicoUI(medico);
        if(ultimoFrame4 != null){
            ultimoFrame4.cerrar();
        }
        ultimoFrame4 = ui;
        ui.armar();
    }
    
    public static void mostrarMenuReportesPaciente(Paciente paciente){
        ReportesPacienteUI ui = new ReportesPacienteUI(paciente);
        if(ultimoFrame4 != null){
            ultimoFrame4.cerrar();
        }
        ultimoFrame4 = ui;
        ui.armar();
    }
    
    public static void mostrarFormularioNuevoTurno(){
        FormularioTurnoUI ui = new FormularioTurnoUI();
        if(ultimoFrame5!= null){
            ultimoFrame5.cerrar();
        }
        ultimoFrame5 = ui;
        ui.armar();
    }
}
