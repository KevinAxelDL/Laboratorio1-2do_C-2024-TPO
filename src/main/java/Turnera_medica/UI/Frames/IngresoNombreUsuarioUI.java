/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.UI.Botones.BotonUI;
import Turnera_medica.UI.Mediadores.AdministradorFrames;
import Turnera_medica.UI.Operaciones.Operacion;
import Turnera_medica.UI.Operaciones.OperacionSobreUsuario;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private OperacionSobreUsuario operacion;
    
    public IngresoNombreUsuarioUI(String titulo, OperacionSobreUsuario operacion){
        super(titulo);
        this.operacion = operacion;
        this.usuarioLabel = new JLabel("Usuario:");
        this.usuarioField = new JTextField();
        this.boton = new BotonUI("OK");
        this.setSize(400, 100);
    }
    
    @Override
     public void armar() {
        
        // Se define el comportamiento del frame 
        this.setLayout(new GridLayout(2, 2)); 
        
        // Accion
        this.boton.setOperacion(this.operacion);
        this.boton.addActionListener(this); 

        
        // Agrega los componentes
        this.add(this.usuarioLabel);
        this.add(this.usuarioField);
        this.add(this.boton);

        // Hace visible el frame
        super.centrar();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.boton){
            // Se preciono el boton
            /*
            try {
                resultado = AdministradorOperaciones.eliminarUsuario(this.usuarioField.getText());
                AdministradorFrames.mostrarMensaje("Operacion exitosa, registros afectados: "+ resultado);
            } catch (OperacionException ex) {
                AdministradorFrames.mostrarMensaje(ex.getMessage());
            }
            */
            this.operacion.setUsuario(this.usuarioField.getText());
            this.boton.setOperacion(operacion);
            try {
                this.boton.activar();
            } catch (OperacionException ex) {
                AdministradorFrames.mostrarMensaje(ex.getMessage());
            }
        }
    }
}
