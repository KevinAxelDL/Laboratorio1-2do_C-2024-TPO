/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;

import javax.swing.JFrame;

/**
 *
 * @author KevinDL
 */
public abstract class UserInterface {
    protected JFrame framePrincipal;
    
    public UserInterface(String titulo){
        this.framePrincipal = new JFrame(titulo);
        this.framePrincipal.setResizable(true);
    }
    
    public void cerrar(){
        this.framePrincipal.dispose();
    };
    
    public abstract void armar();
    
    protected void centrar(){
        // Centra en el medio a la pantalla un frame
        this.framePrincipal.setLocationRelativeTo(null);
    }
}
