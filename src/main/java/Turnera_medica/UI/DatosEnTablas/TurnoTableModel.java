/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.DatosEnTablas;

import Turnera_medica.Modelo.Turno;
import Turnera_medica.Modelo.Usuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author KevinDL
 */
public class TurnoTableModel extends GenericoTableModel<Turno>{
    
    public TurnoTableModel(List<Turno> datosIniciales){
        super(new String[] {"Paciente", "Doctor", "Fecha y hora", "Precio"}, datosIniciales);
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Turno turno = datos.get(rowIndex);
        switch (columnIndex) {
            case 0: return turno.getPaciente().getNombreUsuario();
            case 1: return turno.getMedico().getNombreUsuario();
            case 2: return turno.getFechaYHora();
            case 3: return turno.getPrecio();
            default: return null;
        }
    }

}
