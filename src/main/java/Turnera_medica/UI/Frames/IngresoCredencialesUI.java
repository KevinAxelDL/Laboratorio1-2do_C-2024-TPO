/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;

/**
 *
 * @author KevinDL
 */
import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.UI.Botones.BotonUI;
import Turnera_medica.UI.Mediadores.AdministradorFrames;
import Turnera_medica.UI.Mediadores.AdministradorOperaciones;
import Turnera_medica.UI.Paneles.PanelIngresoTipoUsuarioSimpleUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngresoCredencialesUI extends UserInterface implements ActionListener{
    private JTextField usuarioField; 
    private JPasswordField claveField; 
    private BotonUI boton;
    private PanelIngresoTipoUsuarioSimpleUI panelTipoUsuario;
    
    public IngresoCredencialesUI(){
        super("Ingresar como usuario");
        this.usuarioField = new JTextField(); // Ingreso
        this.claveField = new JPasswordField(); // Ingreso
        this.boton = new BotonUI("OK");
        this.panelTipoUsuario = new PanelIngresoTipoUsuarioSimpleUI();
        this.setSize(650, 190);
    }
    
    @Override
    public void armar() {
        
        // Se define el comportamiento del frame 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Termina el programa una vez cerrado el frame
        this.setLayout(new GridLayout(4, 2, 5, 2)); // 3 filas, 2 columnas
        
        // Accion
        this.boton.addActionListener(this); // Toma como parametro una instancia de una clase que implemente ActionListener

        // Agrega los componentes
        this.add(new JLabel("Usuario:"));
        this.add(usuarioField);
        this.add(new JLabel("Clave:"));
        this.add(claveField);
        this.add(new JLabel("Tipo de usuario"));
        this.add(this.panelTipoUsuario);
        this.add(boton);

        // Hace visible el frame
        this.centrar();
        this.setVisible(true);
    } 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.boton){
            try {
                // Se preciono el boton
                AdministradorOperaciones.ingresarCredenciales(this.usuarioField.getText(), this.claveField.getText(), this.panelTipoUsuario.getTipoSeleccionado());
                this.dispose();
            } catch (OperacionException ex) {
                AdministradorFrames.mostrarMensaje(ex.getMessage());
            }
            
            /*
            this.boton.setOperacion(new IngresoCredencialesOperacion(this.usuarioField.getText(), this.claveField.getText(), this.panelTipoUsuario.getTipoSeleccionado()));
            try {
                this.boton.activar();
                this.dispose();
            } catch (OperacionException ex) {
                AdministradorFrames.mostrarMensaje(ex.getMessage());
            }
            */
        }
    }
}
    
