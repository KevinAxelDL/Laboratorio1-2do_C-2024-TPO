/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.UI.Botones.BotonUI;
import Turnera_medica.UI.Mediadores.AdministradorFrames;
import Turnera_medica.UI.Operaciones.CrearNuevoUsuarioOperacion;
import Turnera_medica.UI.Paneles.PanelIngresoTipoUsuarioUI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
    
    private PanelIngresoTipoUsuarioUI panelTipoUsuario;
    
    private BotonUI botonOk;
    
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
        
        this.panelTipoUsuario = new PanelIngresoTipoUsuarioUI();
        
        this.botonOk = new BotonUI("OK");
 
        this.setSize(800, 350);
    }
    
    @Override
    public void armar() {
        
        // Se define el comportamiento del frame 
        this.setLayout(new GridLayout(7, 2)); // 7 filas, 2 columnas
        
        // Accion
        this.botonOk.addActionListener(this); // Toma como parametro la una instancia de una clase que implemente ActionListener (en este caso es esta instancia)
        
        // Agrega los componentes
        this.add(this.usuarioLabel);
        this.add(this.usuarioField);
        
        this.add(this.claveLabel);
        this.add(this.claveField);
        
        this.add(this.nombreLabel);
        this.add(this.nombreField);
        
        this.add(this.apellidoLabel);
        this.add(this.apellidoField);
        
        this.add(this.dniLabel);
        this.add(this.dniField);
        
        this.add(this.tipoUsuarioLabel);
        this.add(panelTipoUsuario);

        
        this.add(this.botonOk);

        // Hace visible el frame
        super.centrar();
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonOk){
            // Envia formulario
            CrearNuevoUsuarioOperacion operacion =  new CrearNuevoUsuarioOperacion(this.usuarioField.getText(), 
                this.claveField.getText(), this.nombreField.getText(), this.apellidoField.getText(), this.dniField.getText(), 
                this.panelTipoUsuario.getOpcionesSeleccionadas());
            this.botonOk.setOperacion(operacion);
            try {
                this.botonOk.activar();
                AdministradorFrames.mostrarMensaje("OPERACION EXITOSA!");
            } catch (OperacionException ex) {
                AdministradorFrames.mostrarMensaje(ex.getMessage());
            }
        }
    }
}
