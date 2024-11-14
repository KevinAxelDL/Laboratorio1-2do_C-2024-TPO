/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Misc;

import Turnera_medica.Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author KevinDL
 */

public class UsuarioTableModel extends AbstractTableModel {
	
	/**
	 * INDICES DE MIS COLUMNAS
	 */
	private static final int COLUMNA_USUARIO = 0;
        private static final int COLUMNA_CLAVE = 1;
	private static final int COLUMNA_NOMBRE = 2;
        private static final int COLUMNA_APELLIDO = 3;
	private static final int COLUMNA_DNI = 4;
        private static final int COLUMNA_FUNCION = 5;
	
	/**
	 * NOMBRES DE LOS ENCABEZADOS
	 */
	private String[] nombresColumnas = {"Usuario", "Clave", "Nombre", "Apellido", "DNI", "Funcion"};
	/**
	 * TIPOS DE CADA COLUMNA (EN EL MISMO ORDEN DE LOS ENCABEZADOS)
	 */
	private Class[] tiposColumnas = {String.class, String.class, String.class, String.class, Integer.class, String.class,};

	private List<Usuario> contenido;
	
	/**
	 * CONSTRUCTOR VACIO
	 */
	public UsuarioTableModel() {
		contenido = new ArrayList<Usuario>();
	}
	
	/**
	 * CONSTRUCTOR CON CONTENIDO INICIAL
	 */
	public UsuarioTableModel(List<Usuario> contenidoInicial) {
		contenido = contenidoInicial;
	}

	/**
	 * METODO QUE HAY QUE PISAR
	 */
	public int getColumnCount() {
		return nombresColumnas.length;
	}

	/**
	 * OTRO METODO QUE HAY QUE PISAR
	 */
	public int getRowCount() {
		return contenido.size();
	}

	/**
	 * METODO QUE HAY QUE PISAR
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Usuario u = contenido.get(rowIndex);
		
		Object result = null;
		switch(columnIndex) {
		case COLUMNA_USUARIO:
			result = u.getNombreUsuario();
			break;
                case COLUMNA_CLAVE:
                        result = u.getClaveUsuario();
			break;
		case COLUMNA_NOMBRE:
			result = u.getNombre();
			break;
		case COLUMNA_APELLIDO:
			result = u.getApellido();
			break;
		case COLUMNA_DNI:
			result = u.getDni();
			break;
                case COLUMNA_FUNCION:
                        result = u.getNombreClase();
			break;
		default:
			result = new String("");
		}
		
		return result;
	}

	/**
	 * METODO QUE HAY QUE PISAR
	 */
	public String getColumnName(int col) {
        return nombresColumnas[col];
    }

	/**
	 * METODO QUE HAY QUE PISAR
	 */
    public Class getColumnClass(int col) {
        return tiposColumnas[col];
    }

    /**
     * GETTER DE MIS FILAS
     */
    public List<Usuario> getContenido() {
    	return contenido;
    }
    /**
     * SETTER DE MIS FILAS 
     * 
     */
    public void setContenido(List<Usuario> contenido) {
    	this.contenido = contenido;
    }
}
