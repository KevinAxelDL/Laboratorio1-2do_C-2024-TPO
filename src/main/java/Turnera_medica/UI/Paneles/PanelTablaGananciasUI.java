/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Paneles;

import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Servicios.AdministradorServicios;
import Turnera_medica.UI.DatosEnTablas.GananciasTableModel;
import Turnera_medica.UI.Mediadores.AdministradorFrames;
import java.sql.Timestamp;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author KevinDL
 */
public class PanelTablaGananciasUI extends PanelTablaUI{
    private String fechaDesde = "";
    private String fechaHasta = "";
    private String usuarioMedico = "";
    
    public PanelTablaGananciasUI(){
        // Crea JTable y TableModel
        super();
        this.modelo = new GananciasTableModel(this.datos);
        this.tabla = new JTable(modelo);
        this.add(this.tabla);
        this.add(new JScrollPane(tabla));
    }

    
    @Override
    protected void obtenerDatos() {
        try {
            this.datos = AdministradorServicios.listarGanancias(this.fechaDesde, this.fechaHasta, this.usuarioMedico);
        } catch (ServicioException ex) {
            AdministradorFrames.mostrarMensaje(ex.getMessage());
        }
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde +" 00:00:00";
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta +" 00:00:00";
    }

    public void setUsuarioMedico(String usuarioMedico) {
        this.usuarioMedico = usuarioMedico;
    }
    
    
}
