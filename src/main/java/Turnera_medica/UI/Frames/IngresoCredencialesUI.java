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
import Turnera_medica.UI.Operaciones.IngresoCredencialesOperacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngresoCredencialesUI extends UserInterface implements ActionListener{
    private JLabel usuarioLabel; 
    private JLabel claveLabel;
    private JTextField usuarioField; 
    private JPasswordField claveField; 
    private BotonUI boton;
    
    public IngresoCredencialesUI(){
        super("Ingresar como usuario");
        this.usuarioLabel = new JLabel("Usuario:"); 
        this.claveLabel = new JLabel("Clave:");
        this.usuarioField = new JTextField(); // Ingreso
        this.claveField = new JPasswordField(); // Ingreso
        this.boton = new BotonUI("OK");
        this.framePrincipal.setSize(400, 150);
    }
    
    @Override
    public void armar() {
        
        // Se define el comportamiento del frame 
        super.framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Termina el programa una vez cerrado el frame
        super.framePrincipal.setLayout(new GridLayout(3, 2)); // 3 filas, 2 columnas
        
        // Accion
        this.boton.addActionListener(this); // Toma como parametro una instancia de una clase que implemente ActionListener

        // Agrega los componentes
        super.framePrincipal.add(usuarioLabel);
        super.framePrincipal.add(usuarioField);
        super.framePrincipal.add(claveLabel);
        super.framePrincipal.add(claveField);
        super.framePrincipal.add(boton);

        // Hace visible el frame
        super.centrar();
        super.framePrincipal.setVisible(true);
    } 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.boton){
            // Se preciono el boton
            this.boton.setOperacion(new IngresoCredencialesOperacion(this.usuarioField.getText(), this.claveField.getText()));
            try {
                this.boton.activar();
                super.framePrincipal.dispose();
            } catch (OperacionException ex) {
                AdministradorFrames.mostrarMensaje(ex.getMessage());
            }
        }
    }
}
    