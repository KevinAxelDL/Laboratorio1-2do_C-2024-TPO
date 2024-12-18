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

    public PanelTablaTurnosUI(){
        // Crea JTable y TableModel
        super();
        this.modelo = new TurnoTableModel(this.datos);
        this.tabla = new JTable(modelo);
        this.add(this.tabla);
        this.add(new JScrollPane(tabla));
    }

    
    @Override
    protected void obtenerDatos() {
        try {
            this.datos = AdministradorServicios.listarTurnos();
        } catch (ServicioException ex) {
            AdministradorFrames.mostrarMensaje(ex.getMessage());
        }
    }
    
}
