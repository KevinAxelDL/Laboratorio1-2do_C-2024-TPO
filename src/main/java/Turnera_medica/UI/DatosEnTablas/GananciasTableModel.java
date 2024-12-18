/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.DatosEnTablas;

import Turnera_medica.UI.DatosReportes.GananciasReporte;
import java.util.List;

/**
 *
 * @author KevinDL
 */
public class GananciasTableModel extends GenericoTableModel<GananciasReporte>{
    
    public GananciasTableModel(List<GananciasReporte> datosIniciales){
        super(new String[] {"Medico", "Cant.turnos", "Desde", "Hasta", "Gancia total"}, datosIniciales);
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GananciasReporte ganancias = datos.get(rowIndex);
        switch (columnIndex) {
            case 0: return ganancias.getMedico().getNombreUsuario();
            case 1: return ganancias.getCantTurnos();
            case 2: return ganancias.getFechaDesde();
            case 3: return ganancias.getFechaHasta();
            case 4: return ganancias.getGananciaTotal();
            default: return null;
        }
    }

}
