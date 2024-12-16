/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.Modelo.Administrador;
import Turnera_medica.UI.Botones.BotonUI;
import Turnera_medica.UI.Mediadores.AdministradorFrames;
import Turnera_medica.UI.Operaciones.CrearFormularioEliminarUsuarioOperacion;
import Turnera_medica.UI.Operaciones.CrearFormularioNuevoUsuarioOperacion;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author KevinDL
 */
public class MenuAdministradorUI extends MenuUI implements ActionListener{
    
    private BotonUI botonCrearUsuario;
    private BotonUI botonEliminarUsuario;
    private BotonUI botonVerUsuarios;
    private BotonUI botonModificarUsuario;
    
    public MenuAdministradorUI(Administrador administrador){
        super("Menu administrador", administrador);
        this.botonCrearUsuario = new BotonUI("Crear usuario");
        this.botonEliminarUsuario = new BotonUI("Eliminar usuario");
        this.botonVerUsuarios = new BotonUI("Reportes");
        this.botonModificarUsuario = new BotonUI("Modificar usuario");
        super.configurarPorDefault();
    }
    
    public void armar() {
        
        // Se define el comportamiento del frame 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Termina el programa una vez cerrado el frame
        this.setLayout(new GridLayout(5, 1));
        
        // Accion
        this.botonCrearUsuario.addActionListener(this);
        this.botonEliminarUsuario.addActionListener(this);
        this.botonModificarUsuario.addActionListener(this);
        this.botonVerUsuarios.addActionListener(this);

        // Agrega los componentes
        this.add(super.panelInfoUsuario);
        this.add(botonCrearUsuario);
        this.add(botonEliminarUsuario);
        this.add(botonModificarUsuario);
        this.add(botonVerUsuarios);

        // Hace visible el frame
        super.centrar();
        this.setVisible(true);
    }
    
    private void crearFormularioModificarUsuario(){
        AdministradorFrames.mostrarMensaje("NOTA: FALTA IMPLEMENTACION");
    }
    
    private void crearListadoReportes(){
        ReportesAdministradorUI listadoReportes = new ReportesAdministradorUI();
        listadoReportes.armar();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Abre un frame diferente dependiento del boton clickeado
        
        if(e.getSource() == this.botonCrearUsuario){
            CrearFormularioNuevoUsuarioOperacion operacion = new CrearFormularioNuevoUsuarioOperacion();
            this.botonCrearUsuario.setOperacion(operacion);
            try {
                this.botonCrearUsuario.activar();
            } catch (OperacionException ex) {
                AdministradorFrames.mostrarMensaje(ex.getMessage());
            }
        }
        
        if(e.getSource() == this.botonEliminarUsuario){
            CrearFormularioEliminarUsuarioOperacion operacion = new CrearFormularioEliminarUsuarioOperacion();
            this.botonEliminarUsuario.setOperacion(operacion);
            try {
                this.botonEliminarUsuario.activar();
            } catch (OperacionException ex) {
                AdministradorFrames.mostrarMensaje(ex.getMessage());
            }
        }
        
        if(e.getSource() == this.botonModificarUsuario){
            crearFormularioModificarUsuario();// REEMPLAZAR POR BOTONUI
        }
        
        if(e.getSource() == this.botonVerUsuarios){
            crearListadoReportes();// REEMPLAZAR POR BOTONUI
        }
    }
}
