/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Paneles;

import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author KevinDL
 */
public abstract class PanelTablaUI extends JPanel{
    protected JTable tabla;
    
    public abstract void actualizar();
    
    protected abstract void obtenerDatos();
}
