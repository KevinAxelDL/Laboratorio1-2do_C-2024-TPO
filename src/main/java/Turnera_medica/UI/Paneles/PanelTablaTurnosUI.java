/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Paneles;

import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Servicios.AdministradorServicios;
import Turnera_medica.UI.DatosEnTablas.TurnoTableModel;
import Turnera_medica.UI.Mediadores.AdministradorFrames;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author KevinDL
 */
public class PanelTablaTurnosUI extends PanelTablaUI{
    private String nombreUsuario;
    private Class<?> tipoUsuario;
            
    public PanelTablaTurnosUI(){
        // Crea JTable y TableModel
        super();
        this.modelo = new TurnoTableModel(this.datos);
        this.tabla = new JTable(modelo);
        this.add(this.tabla);
        this.add(new JScrollPane(tabla));
    }
    
    public PanelTablaTurnosUI(String nombreUsuario, Class<?> tipoUsuario){
        // Crea JTable y TableModel
        super();
        this.modelo = new TurnoTableModel(this.datos);
        this.tabla = new JTable(modelo);
        this.nombreUsuario = nombreUsuario;
        this.tipoUsuario = tipoUsuario;
        this.add(this.tabla);
        this.add(new JScrollPane(tabla));
    }
    
    @Override
    protected void obtenerDatos() {
        try {
            if(this.nombreUsuario == null && this.tipoUsuario == null){
                this.datos = AdministradorServicios.listarTurnos();
            }else{
                this.datos = AdministradorServicios.listarTurnos(this.nombreUsuario, this.tipoUsuario);
            }
            
        } catch (ServicioException ex) {
            AdministradorFrames.mostrarMensaje(ex.getMessage());
        }
    }
    
}
