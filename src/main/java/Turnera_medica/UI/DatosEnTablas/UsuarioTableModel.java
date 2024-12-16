/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.DatosEnTablas;

import Turnera_medica.Modelo.Usuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author KevinDL
 */
public class UsuarioTableModel extends AbstractTableModel{
    
    private String[] nombresColumnas = {"Nombre", "Apellido", "DNI", "Usuario", "Clave", "Funcion"};
    private List<Usuario> usuarios;
    
    public UsuarioTableModel(List<Usuario> contenidoInicial) {
	this.usuarios = contenidoInicial;
    }
    
    @Override
    public int getRowCount() {
        return this.usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.length;
    }
    
    public void setContenido(List<Usuario> datos) {
        this.usuarios = datos;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = usuarios.get(rowIndex);
        switch (columnIndex) {
            case 0: return usuario.getNombre();
            case 1: return usuario.getApellido();
            case 2: return usuario.getDni();
            case 3: return usuario.getNombreUsuario();
            case 4: return usuario.getClaveUsuario();
            case 5: return usuario.getTipoUsuario();
            default: return null;
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public String getColumnName(int columna) {
        return nombresColumnas[columna];
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }  
}
