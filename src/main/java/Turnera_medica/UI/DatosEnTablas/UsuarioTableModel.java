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
public class UsuarioTableModel extends GenericoTableModel<Usuario>{

    public UsuarioTableModel(List<Usuario> contenidoInicial) {
        super(new String[] {"Nombre", "Apellido", "DNI", "Usuario", "Clave", "Funcion"},contenidoInicial);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = datos.get(rowIndex);
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
    /*
    @Override
    public void setDatos(List<Usuario> usuarios) {
        this.datos = usuarios;
    }  
    */
}
