/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.Modelo.Administrador;
import Turnera_medica.UI.Botones.BotonUI;
import Turnera_medica.UI.Mediadores.AdministradorFrames;
import Turnera_medica.UI.Operaciones.CrearNuevoUsuarioOperacion;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.lang.Class;

/**
 *
 * @author KevinDL
 */
public class FormularioUsuarioUI extends UserInterface implements ActionListener{
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

    private BotonUI botonOk;
    private JRadioButton opcion1;
    private JRadioButton opcion2;
    private JRadioButton opcion3;
    private ButtonGroup grupo;
    
    private Class<?> opcionSeleccionada;
    
    public FormularioUsuarioUI(){
        super("Crear un nuevo usuario");
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
        
        this.botonOk = new BotonUI("OK");
        this.opcion1 = new JRadioButton("ADMINISTRADOR");
        this.opcion2 = new JRadioButton("MEDICO");
        this.opcion3 = new JRadioButton("PACIENTE");
        this.grupo = new ButtonGroup();
        
        // Se agrupan para asegurar una sola opcion seleccionada
        this.grupo.add(opcion1);
        this.grupo.add(opcion2);
        this.grupo.add(opcion3);
        
        this.opcionSeleccionada = null;
        
        super.framePrincipal.setSize(800, 350);
    }
    
    @Override
    public void armar() {
        
        // Se define el comportamiento del frame 
        super.framePrincipal.setLayout(new GridLayout(7, 2)); // 7 filas, 2 columnas
        
        // Accion
        this.botonOk.addActionListener(this); // Toma como parametro la una instancia de una clase que implemente ActionListener (en este caso es esta instancia)
        this.opcion1.addActionListener(this);
        this.opcion2.addActionListener(this);
        this.opcion3.addActionListener(this);
        
        // Agrega los componentes
        super.framePrincipal.add(this.usuarioLabel);
        super.framePrincipal.add(this.usuarioField);
        
        super.framePrincipal.add(this.claveLabel);
        super.framePrincipal.add(this.claveField);
        
        super.framePrincipal.add(this.nombreLabel);
        super.framePrincipal.add(this.nombreField);
        
        super.framePrincipal.add(this.apellidoLabel);
        super.framePrincipal.add(this.apellidoField);
        
        super.framePrincipal.add(this.dniLabel);
        super.framePrincipal.add(this.dniField);
        
        super.framePrincipal.add(this.tipoUsuarioLabel);

        JPanel opcionesPanel = new JPanel(); 
        opcionesPanel.add(this.opcion1);
        opcionesPanel.add(this.opcion2);
        opcionesPanel.add(this.opcion3);
        super.framePrincipal.add(opcionesPanel); // Se asignan los botones a un panel y se agregan al frame
        
        super.framePrincipal.add(this.botonOk);

        // Hace visible el frame
        super.centrar();
        super.framePrincipal.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonOk){
            // Envia formulario
            CrearNuevoUsuarioOperacion operacion =  new CrearNuevoUsuarioOperacion(this.usuarioField.getText(), this.claveField.getText(), this.nombreField.getText(), this.apellidoField.getText(), this.dniField.getText(), this.opcionSeleccionada);
            this.botonOk.setOperacion(operacion);
            try {
                this.botonOk.activar();
                AdministradorFrames.mostrarMensaje("OPERACION EXITOSA!");
            } catch (OperacionException ex) {
                AdministradorFrames.mostrarMensaje(ex.getMessage());
            }
        }
        
        if(e.getSource() == this.opcion1){// ADMINISTRADOR
            this.opcionSeleccionada = Administrador.class;
        }
        
        if(e.getSource() == this.opcion2){// MEDICO
            //this.opcionSeleccionada = Medico.class;
            this.opcionSeleccionada = null;
        }
        
        if(e.getSource() == this.opcion3){// PACIENTE
            //this.opcionSeleccionada = Paciente.class;
            this.opcionSeleccionada = null;
        }
    }
}
