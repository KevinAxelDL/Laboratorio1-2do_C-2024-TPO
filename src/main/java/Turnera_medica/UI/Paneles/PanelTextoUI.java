/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Paneles;

import javax.swing.JPanel;

/**
 *
 * @author KevinDL
 */
public class PanelTextoUI extends JPanel{
    private String texto;
    
    public PanelTextoUI(String texto){
        this.texto = texto;
    }
    
    public String getTexto(){
        return this.texto;
    }
}
