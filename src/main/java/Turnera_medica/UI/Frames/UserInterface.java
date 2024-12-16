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
public abstract class UserInterface extends JFrame{
    
    public UserInterface(String titulo){
        super(titulo);
        this.setResizable(true);
    }
    
    public void cerrar(){
        this.dispose();
    };
    
    public abstract void armar();
    
    protected void centrar(){
        // Centra en el medio de la pantalla un frame
        this.setLocationRelativeTo(null);
    }
}
