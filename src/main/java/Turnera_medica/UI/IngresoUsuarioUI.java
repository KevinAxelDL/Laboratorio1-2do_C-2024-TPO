/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI;

import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Modelo.Usuario;
import Turnera_medica.Servicios.AdministradorServicios;
import Turnera_medica.Servicios.UsuarioServicios;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author KevinDL
 */
public class IngresoUsuarioUI implements ActionListener{
    private JFrame framePrincipal;
    private JLabel usuarioLabel; 
    private JTextField usuarioField; 
    private JButton boton;
    
    public IngresoUsuarioUI(){
        this.framePrincipal = new JFrame("Ingrese un usuario");
        this.usuarioLabel = new JLabel("Usuario:");
        this.usuarioField = new JTextField();
        this.boton = new JButton("OK");
    }
    
     public void armar() {
        
        // Se define el comportamiento del frame 
        this.framePrincipal.setSize(400, 100);
        this.framePrincipal.setLayout(new GridLayout(2, 2)); 
        
        // Accion
        this.boton.addActionListener(this); 

        
        // Agrega los componentes
        this.framePrincipal.add(this.usuarioLabel);
        this.framePrincipal.add(this.usuarioField);
        this.framePrincipal.add(this.boton);

        // Hace visible el frame
        framePrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.boton){
            // Se preciono el boton
            hacerAccion(this.usuarioField.getText());
            this.framePrincipal.dispose();
        }
    }
    
    private void hacerAccion(String usuario){
        int resultado;
        try {
            // Accion del boton
            resultado = AdministradorServicios.eliminarAdministrador(usuario);
            MensajeUI mensaje = new MensajeUI("Operacion exitosa, registros afectados: "+ resultado);
            mensaje.mostrar();
        } catch (ServicioException ex) {
            MensajeUI mensaje = new MensajeUI(ex.getMessage());
            mensaje.mostrar();
        }
    }
}
