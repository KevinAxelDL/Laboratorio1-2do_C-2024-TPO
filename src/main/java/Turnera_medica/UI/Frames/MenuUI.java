/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;

import Turnera_medica.Modelo.Usuario;
import Turnera_medica.UI.Botones.BotonUI;
import Turnera_medica.UI.Mediadores.AdministradorFrames;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author KevinDL
 */
public abstract class MenuUI extends UserInterface implements ActionListener{
    protected JPanel panelInfoUsuario;
    protected BotonUI botonCerrarSesion;
    
    public MenuUI(String texto, Usuario usuario, int filas){
        super(texto);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Termina el programa una vez cerrado el frame
        
        this.panelInfoUsuario = new JPanel();
        this.panelInfoUsuario.setLayout(new GridLayout(2,1));
        
        this.panelInfoUsuario.add(new JLabel("Usuario activo: "+ usuario.getNombreUsuario()));
        this.panelInfoUsuario.add(new JLabel("Permisos actuales: "+ usuario.getTipoUsuario()));
        
        this.botonCerrarSesion = new BotonUI("[ Cerrar sesion [X] ]");
        
        this.setLayout(new GridLayout(filas,1));
        
        this.configurarPorDefault();
    }
    
    @Override
    public void armar(){
        
        this.botonCerrarSesion.addActionListener(this);
        this.add(this.panelInfoUsuario);
        this.add(this.botonCerrarSesion);
    }
    
    protected void configurarPorDefault(){
        this.setSize(650, 500);
    }
    
    protected void cerrarSesion(){
        AdministradorFrames.mostrarIngresoCredenciales();
        this.cerrar();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonCerrarSesion){
            this.cerrarSesion();
        }
    }
    
    
}
