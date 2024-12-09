/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.UI.Botones.BotonUI;
import Turnera_medica.UI.Mediadores.AdministradorFrames;
import Turnera_medica.UI.Operaciones.EliminarUsuarioOperacion;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author KevinDL
 */
public class IngresoNombreUsuarioUI extends UserInterface implements ActionListener{
    private JLabel usuarioLabel; 
    private JTextField usuarioField; 
    private BotonUI boton;
    
    public IngresoNombreUsuarioUI(String titulo){
        super(titulo);
        this.usuarioLabel = new JLabel("Usuario:");
        this.usuarioField = new JTextField();
        this.boton = new BotonUI("OK");
        this.framePrincipal.setSize(400, 100);
    }
    
    @Override
     public void armar() {
        
        // Se define el comportamiento del frame 
        super.framePrincipal.setLayout(new GridLayout(2, 2)); 
        
        // Accion
        this.boton.addActionListener(this); 

        
        // Agrega los componentes
        super.framePrincipal.add(this.usuarioLabel);
        super.framePrincipal.add(this.usuarioField);
        super.framePrincipal.add(this.boton);

        // Hace visible el frame
        super.centrar();
        super.framePrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.boton){
            // Se preciono el boton
            EliminarUsuarioOperacion operacion = new EliminarUsuarioOperacion(usuarioField.getText());
            this.boton.setOperacion(operacion);
            try {
                this.boton.activar();
            } catch (OperacionException ex) {
                AdministradorFrames.mostrarMensaje(ex.getMessage());
            }
        }
    }
}
