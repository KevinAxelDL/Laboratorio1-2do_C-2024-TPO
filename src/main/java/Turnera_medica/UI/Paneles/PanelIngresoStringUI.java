/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Paneles;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author KevinDL
 */
public class PanelIngresoStringUI extends JPanel{
    private JTextField ingresado;
    
    public PanelIngresoStringUI(){
        this.ingresado = new JTextField();
        this.ingresado.setPreferredSize(new Dimension(150, 20));
        this.add(ingresado);
    }
    
    public String getTexto(){
        return ingresado.getText();
    }
}
