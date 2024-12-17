/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.DatosEnTablas;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author KevinDL
 */
public abstract class GenericoTableModel<T> extends AbstractTableModel{
    protected String[] nombresColumnas;
    protected List<T> datos; //Lista con tipo de dato variable
    
    public GenericoTableModel(String[] nombres, List<T> datosIniciales){
        this.nombresColumnas = nombres;
        this.datos = datosIniciales;
    }
    
    public void setDatos(List<T> datos){
        this.datos = datos;
    };
    
    @Override
    public int getRowCount() {
        return this.datos.size();
    }
    
    @Override
    public int getColumnCount() {
        return this.nombresColumnas.length;
    } 
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public String getColumnName(int columna) {
        return nombresColumnas[columna];
    }
}
