/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI;

import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Servicios.AdministradorServicios;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author KevinDL
 */
public class FormularioUsuarioUI implements ActionListener{
    private JFrame framePrincipal;
    private JLabel usuarioLabel; 
    private JLabel claveLabel;
    private JLabel nombreLabel;
    private JLabel apellidoLabel;
    private JLabel dniLabel;
    private JLabel tipoUsuarioLabel;
    
    private JTextField usuarioField; 
    private JPasswordField claveField;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField dniField;

    private JButton boton;
    private JRadioButton opcion1;
    private JRadioButton opcion2;
    private JRadioButton opcion3;
    private ButtonGroup grupo;
    
    private String opcionSeleccionada;
    
    public FormularioUsuarioUI(){
        this.framePrincipal = new JFrame("Crear/Modificar un nuevo usuario");
        this.usuarioLabel = new JLabel("Usuario:"); 
        this.claveLabel = new JLabel("Clave:");
        this.nombreLabel = new JLabel("Nombre:");
        this.apellidoLabel = new JLabel("Apellido:");
        this.dniLabel = new JLabel("DNI:");
        this.tipoUsuarioLabel = new JLabel("Tipo de usuario:");
        
        this.usuarioField = new JTextField(); 
        this.claveField = new JPasswordField();
        this.nombreField = new JTextField(); 
        this.apellidoField = new JTextField();
        this.dniField = new JTextField();
        
        this.boton = new JButton("OK");
        this.opcion1 = new JRadioButton("ADMINISTRADOR");
        this.opcion2 = new JRadioButton("ADMINISTRADOR"); // CAMBIAR A MEDICO
        this.opcion3 = new JRadioButton("ADMINISTRADOR"); // CAMBIAR A PACIENTE
        this.grupo = new ButtonGroup();
        
        // Se agrupan para asegurar una sola opcion seleccionada
        this.grupo.add(opcion1);
        this.grupo.add(opcion2);
        this.grupo.add(opcion3);
        
        this.opcionSeleccionada = null;
    }
    
    public void armar() {
        
        // Se define el comportamiento del frame 
        this.framePrincipal.setSize(800, 350);
        this.framePrincipal.setLayout(new GridLayout(7, 2)); // 7 filas, 2 columnas
        
        // Accion
        this.boton.addActionListener(this); // Toma como parametro la una instancia de una clase que implemente ActionListener (en este caso es esta instancia)
        this.opcion1.addActionListener(this);
        this.opcion2.addActionListener(this);
        this.opcion3.addActionListener(this);
        
        // Agrega los componentes
        this.framePrincipal.add(this.usuarioLabel);
        this.framePrincipal.add(this.usuarioField);
        
        this.framePrincipal.add(this.claveLabel);
        this.framePrincipal.add(this.claveField);
        
        this.framePrincipal.add(this.nombreLabel);
        this.framePrincipal.add(this.nombreField);
        
        this.framePrincipal.add(this.apellidoLabel);
        this.framePrincipal.add(this.apellidoField);
        
        this.framePrincipal.add(this.dniLabel);
        this.framePrincipal.add(this.dniField);
        
        this.framePrincipal.add(this.tipoUsuarioLabel);

        JPanel opcionesPanel = new JPanel(); 
        opcionesPanel.add(this.opcion1);
        opcionesPanel.add(this.opcion2);
        opcionesPanel.add(this.opcion3);
        this.framePrincipal.add(opcionesPanel); // Se asignan los botones a un panel y se agregan al frame
        
        this.framePrincipal.add(this.boton);

        // Hace visible el frame
        framePrincipal.setVisible(true);
    }
    
    private void hacerAccion(String usuario, String clave, String nombre, String apellido, String dni, String opcionSeleccionada){
        // Accion del boton
        //NOTA: DE MOMENTO SOLO SE PUEDE CREAR UN ADMINISTRADOR, UN SWITCH A FUTURO NO ES IDEAL PARA DETERMINAR QUE USARIO SE CREA
        int dniComoInt;
        
        try {
            dniComoInt = Integer.parseInt(dni); // Los caracteres deben ser numeros
            Administrador nuevoAdmin = new Administrador(dniComoInt,  nombre,  apellido, usuario, clave);
            
            try {
                AdministradorServicios.registrarAdministrador(nuevoAdmin);
                MensajeUI mensaje = new MensajeUI("Usuario registrado exitosamente!");
                mensaje.mostrar();
                framePrincipal.dispose();
                
            } catch (ServicioException ex) {
                MensajeUI mensaje = new MensajeUI(ex.getMessage());
                mensaje.mostrar();
            }
            
        } catch (NumberFormatException e) {
            MensajeUI mensaje = new MensajeUI("DNI NO VALIDO!");
            mensaje.mostrar();
        } 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.boton){
            // Se preciono el boton
            hacerAccion(this.usuarioField.getText(), this.claveField.getText(), this.nombreField.getText(), this.apellidoField.getText(), this.dniField.getText(), this.opcionSeleccionada);
        }
        
        if(e.getSource() == this.opcion1){
            this.opcionSeleccionada = this.opcion1.getText();
        }
        
        if(e.getSource() == this.opcion2){
            this.opcionSeleccionada = this.opcion2.getText();
        }
        
        if(e.getSource() == this.opcion3){
            this.opcionSeleccionada = this.opcion3.getText();
        }
    }
    
    
}
