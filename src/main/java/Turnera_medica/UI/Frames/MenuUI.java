/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;

import Turnera_medica.Modelo.Usuario;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author KevinDL
 */
public abstract class MenuUI extends UserInterface implements ActionListener{
    protected JPanel panelInfoUsuario;
    
    public MenuUI(String texto, Usuario usuario){
        super(texto);
        
        this.panelInfoUsuario = new JPanel();
        this.panelInfoUsuario.setLayout(new GridLayout(2,1));
        
        this.panelInfoUsuario.add(new JLabel("Usuario activo: "+ usuario.getNombreUsuario()));
        this.panelInfoUsuario.add(new JLabel("Permisos actuales: "+ usuario.getTipoUsuario()));
    }
    
    @Override
    public void armar(){
        this.add(this.panelInfoUsuario);
    }
    
    protected void configurarPorDefault(){
        this.setSize(650, 500);
    }
    
}
