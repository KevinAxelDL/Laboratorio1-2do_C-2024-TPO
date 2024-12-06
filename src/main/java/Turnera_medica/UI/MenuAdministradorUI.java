/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.Modelo.Administrador;
import Turnera_medica.UI.Misc.AdministradorPaneles;
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
public class MenuAdministradorUI implements ActionListener, UserInterface{
    private JFrame framePrincipal;
    private JLabel infoLabel; 
    private BotonUI botonCrearUsuario;
    private BotonUI botonEliminarUsuario;
    private BotonUI botonVerUsuarios;
    private BotonUI botonModificarUsuario;
    
    public MenuAdministradorUI(Administrador administrador){
        framePrincipal = new JFrame("Menu administrador");
        infoLabel = new JLabel("Usuario activo: "+ administrador.getNombreUsuario());
        botonCrearUsuario = new BotonUI("Crear usuario");
        botonEliminarUsuario = new BotonUI("Eliminar usuario");
        botonVerUsuarios = new BotonUI("Listar");
        botonModificarUsuario = new BotonUI("Modificar usuario");
        this.infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    public void armar() {
        
        // Se define el comportamiento del frame 
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Termina el programa una vez cerrado el frame
        framePrincipal.setSize(650, 500);
        framePrincipal.setLayout(new GridLayout(5, 1));
        
        // Accion
        this.botonCrearUsuario.addActionListener(this);
        this.botonEliminarUsuario.addActionListener(this);
        this.botonModificarUsuario.addActionListener(this);
        this.botonVerUsuarios.addActionListener(this);

        // Agrega los componentes
        framePrincipal.add(infoLabel);
        framePrincipal.add(botonCrearUsuario);
        framePrincipal.add(botonEliminarUsuario);
        framePrincipal.add(botonModificarUsuario);
        framePrincipal.add(botonVerUsuarios);

        // Hace visible el frame
        framePrincipal.setVisible(true);
    }
    
    private void crearFormularioEliminarUsuario(){
        // Accion del boton
        IngresoUsuarioUI menu = new IngresoUsuarioUI();
        menu.armar();
    }
    
    private void crearFormularioModificarUsuario(){
        // Accion del boton
        IngresoUsuarioUI menu = new IngresoUsuarioUI();
        //menu.armar();
        AdministradorPaneles.mostrarMensaje("NOTA: FALTA IMPLEMENTACION");
    }
    
    private void crearListadoUsuarios(){
        // Accion del boton
        IngresoUsuarioUI menu = new IngresoUsuarioUI();
        //menu.armar();
        AdministradorPaneles.mostrarMensaje("NOTA: FALTA IMPLEMENTACION");
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
                AdministradorPaneles.mostrarMensaje(ex.getMessage());
            }
        }
        
        if(e.getSource() == this.botonEliminarUsuario){
            crearFormularioEliminarUsuario();// REEMPLAZAR POR BOTONUI
        }
        
        if(e.getSource() == this.botonModificarUsuario){
            crearFormularioModificarUsuario();// REEMPLAZAR POR BOTONUI
        }
        
        if(e.getSource() == this.botonVerUsuarios){
            crearListadoUsuarios();// REEMPLAZAR POR BOTONUI
        }
    }

    @Override
    public void cerrar() {
        this.framePrincipal.dispose();
    }
}
