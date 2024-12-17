/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Paneles;

import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Modelo.Usuario;
import Turnera_medica.Servicios.AdministradorServicios;
import Turnera_medica.UI.DatosEnTablas.UsuarioTableModel;
import Turnera_medica.UI.Mediadores.AdministradorFrames;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author KevinDL
 */
public class PanelTablaUsuariosUI extends PanelTablaUI<Usuario>{
    //private List<Usuario> usuarios;
    //private UsuarioTableModel modelo;
    
    public PanelTablaUsuariosUI(){
        // Crea JTable y TableModel
        super();
        this.modelo = new UsuarioTableModel(this.datos);
        this.tabla = new JTable(modelo);
        this.add(this.tabla);
        this.add(new JScrollPane(tabla));
    }

    @Override
    protected void obtenerDatos() {
        try {
            this.datos = AdministradorServicios.listarUsuariosConFuncion(); // Retorna los usuarios en una lista
        } catch (ServicioException ex) {
            AdministradorFrames.mostrarMensaje(ex.getMessage());
        }
    }
}

