/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;


import Turnera_medica.Modelo.Administrador;
import Turnera_medica.UI.Botones.BotonUI;
import Turnera_medica.UI.Mediadores.AdministradorFrames;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


/**
 *
 * @author KevinDL
 */
public class MenuAdministradorUI extends MenuUI implements ActionListener{
    
    private BotonUI botonCrearUsuario;
    private BotonUI botonEliminarUsuario;
    private BotonUI botonVerReportes;
    private BotonUI botonModificarUsuario;
    private BotonUI botonCrearTurno;
    
    public MenuAdministradorUI(Administrador administrador){
        super("Menu administrador", administrador, 7);
        this.botonCrearUsuario = new BotonUI("Cargar usuario");
        this.botonEliminarUsuario = new BotonUI("Eliminar usuario");
        this.botonVerReportes = new BotonUI("Reportes");
        this.botonModificarUsuario = new BotonUI("Modificar usuario");
        this.botonCrearTurno = new BotonUI("Cargar turno");
        
        // Se define el comportamiento del frame 
        
    }
    
    public void armar() {
        // Accion
        this.botonCrearUsuario.addActionListener(this);
        this.botonEliminarUsuario.addActionListener(this);
        this.botonModificarUsuario.addActionListener(this);
        this.botonCrearTurno.addActionListener(this);
        this.botonVerReportes.addActionListener(this);

        // Agrega los componentes
        super.armar();
        this.add(botonCrearUsuario);
        this.add(botonEliminarUsuario);
        this.add(botonModificarUsuario);
        this.add(this.botonCrearTurno);
        this.add(botonVerReportes);

        // Hace visible el frame
        super.centrar();
        this.setVisible(true);
    }
    
    private void crearFormularioModificarUsuario(){
        AdministradorFrames.mostrarMensaje("NOTA: FALTA IMPLEMENTACION");
    }
      
    @Override
    public void actionPerformed(ActionEvent e) {
        // Abre un frame diferente dependiento del boton clickeado
        super.actionPerformed(e);
        
        if(e.getSource() == this.botonCrearUsuario){
            AdministradorFrames.mostrarFormularioNuevoUsuario();
        }
        
        if(e.getSource() == this.botonEliminarUsuario){
            AdministradorFrames.mostrarIngresoNombreUsuario("Eliminar usuario");
        }
        
        if(e.getSource() == this.botonModificarUsuario){
            crearFormularioModificarUsuario();
        }
        
        if(e.getSource() == this.botonVerReportes){
            AdministradorFrames.mostrarMenuReportesAdministrador();
        }
        
        if(e.getSource() == this.botonCrearTurno){
            AdministradorFrames.mostrarFormularioNuevoTurno();
        }
        
        if(e.getSource() == this.botonCerrarSesion){
            this.cerrarSesion();
        }
    }
}
