/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Paneles;

import Turnera_medica.UI.DatosEnTablas.GenericoTableModel;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author KevinDL
 */
public abstract class PanelTablaUI<T> extends JPanel{
    protected JTable tabla;
    protected GenericoTableModel modelo;
    protected List<T> datos;
    
    public PanelTablaUI(){
        obtenerDatos();
        this.setLayout(new BorderLayout());// Permite que los contenidos se expandan hasta el borde del panel
    }
    
    public void actualizar(){
        obtenerDatos();
        // Actualiza el modelo
        this.modelo.setDatos(this.datos); 
        this.modelo.fireTableDataChanged();
    }
    
    protected abstract void obtenerDatos();
    
    
}
