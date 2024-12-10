/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;

import javax.swing.JLabel;

/**
 *
 * @author KevinDL
 */
public abstract class MenuUI extends UserInterface{
    protected JLabel infoLabel; 
    
    public MenuUI(String texto){
        super(texto);
    }
    
    protected void configurarPorDefault(){
        super.framePrincipal.setSize(650, 500);
    }
    
}
