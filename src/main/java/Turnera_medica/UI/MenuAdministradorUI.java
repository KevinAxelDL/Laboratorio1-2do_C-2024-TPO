/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI;

import Turnera_medica.Modelo.Administrador;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author KevinDL
 */
public class MenuAdministradorUI implements ActionListener{
    private JFrame framePrincipal;
    private JLabel infoLabel; 
    private JButton botonCrearUsuario;
    private JButton botonEliminarUsuario;
    private JButton botonVerUsuarios;
    private JButton botonModificarUsuario;
    
    public MenuAdministradorUI(Administrador administrador){
        framePrincipal = new JFrame("Menu administrador");
        infoLabel = new JLabel("Usuario activo: "+ administrador.getNombreUsuario());
        botonCrearUsuario = new JButton("Crear usuario");
        botonEliminarUsuario = new JButton("Eliminar usuario");
        botonVerUsuarios = new JButton("Listar");
        botonModificarUsuario = new JButton("Modificar usuario");
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
    
    private void crearFormularioNuevoUsuario(){
        // Accion del boton
        FormularioUsuarioUI menu = new FormularioUsuarioUI();
        menu.armar();
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
        MensajeUI mensaje = new MensajeUI("NOTA: FALTA IMPLEMENTACION");
        mensaje.mostrar();
    }
    
    private void crearListadpUsuarios(){
        // Accion del boton
        IngresoUsuarioUI menu = new IngresoUsuarioUI();
        //menu.armar();
        MensajeUI mensaje = new MensajeUI("NOTA: FALTA IMPLEMENTACION");
        mensaje.mostrar();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // Abre un frame diferente dependiento del boton
        
        if(e.getSource() == this.botonCrearUsuario){
            crearFormularioNuevoUsuario();
        }
        
        if(e.getSource() == this.botonEliminarUsuario){
            crearFormularioEliminarUsuario();
        }
        
        if(e.getSource() == this.botonModificarUsuario){
            crearFormularioModificarUsuario();
        }
        
        if(e.getSource() == this.botonVerUsuarios){
            crearListadpUsuarios();
        }
    }
}
