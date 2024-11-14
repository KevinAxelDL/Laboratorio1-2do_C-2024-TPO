/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI;

/**
 *
 * @author KevinDL
 */
import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Modelo.Usuario;
import Turnera_medica.Servicios.UsuarioServicios;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngresoCredencialesUI implements ActionListener{
    private JFrame framePrincipal;
    private JLabel usuarioLabel; 
    private JLabel claveLabel;
    private JTextField usuarioField; 
    private JPasswordField claveField; 
    JButton boton = new JButton("OK");
    
    public IngresoCredencialesUI(){
        this.framePrincipal = new JFrame("Ingresar como usuario");
        this.usuarioLabel = new JLabel("Usuario:"); 
        this.claveLabel = new JLabel("Clave:");
        this.usuarioField = new JTextField(); // Ingreso
        this.claveField = new JPasswordField(); // Ingreso
        this.boton = new JButton("OK");
    }
    
    public void armar() {
        
        // Se define el comportamiento del frame 
        this.framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Termina el programa una vez cerrado el frame
        this.framePrincipal.setSize(400, 150);
        this.framePrincipal.setLayout(new GridLayout(3, 2)); // 3 filas, 2 columnas
        
        // Accion
        this.boton.addActionListener(this); // Toma como parametro la una instancia de una clase que implemente ActionListener

        // Agrega los componentes
        this.framePrincipal.add(usuarioLabel);
        this.framePrincipal.add(usuarioField);
        this.framePrincipal.add(claveLabel);
        this.framePrincipal.add(claveField);
        this.framePrincipal.add(boton);

        // Hace visible el frame
        framePrincipal.setVisible(true);
    }
    
    private void hacerAccion(String usuario, String clave){
        // Accion del boton
        // NOTA: debe moficarse para que abra el menu que corresponde segun el tipo de usuario
        Usuario usuarioRetornado = null;
        try {
            usuarioRetornado = UsuarioServicios.ingresarComoUsuario(usuario, clave);
        } catch (ServicioException ex) {
            MensajeUI mensaje = new MensajeUI(ex.getMessage()); // Muestra un frame con un mensaje
            mensaje.mostrar();
        }
        crearMenu((Administrador) usuarioRetornado); // Segun la clase del usuario a abre un menu disitinto
    }
    
    private void crearMenu(Administrador a){
        // El usuario es administrador, se le mostrara un menu correspondiente
        MenuAdministradorUI menu = new MenuAdministradorUI(a);
        menu.armar();
        framePrincipal.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.boton){
            // Se preciono el boton
            System.out.println(this.usuarioField.getText());
            System.out.println(this.claveField.getText());
            hacerAccion(this.usuarioField.getText(), this.claveField.getText());
        }
    }
}
    
