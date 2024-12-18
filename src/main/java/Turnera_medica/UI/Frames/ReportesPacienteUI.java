/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.Modelo.Medico;
import Turnera_medica.Modelo.Paciente;
import Turnera_medica.UI.Botones.BotonUI;
import Turnera_medica.UI.Mediadores.AdministradorFrames;
import Turnera_medica.UI.Paneles.PanelTablaTurnosUI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

/**
 *
 * @author KevinDL
 */
public class ReportesPacienteUI extends ReportesUI{
    private PanelTablaTurnosUI panelTablaReporteTurnos;
    private BotonUI botonReporteTurnos;
    private Paciente paciente;
    
    public ReportesPacienteUI(Paciente paciente){
        super();
        
        this.botonReporteTurnos = new BotonUI("Actualizar");
        this.botonReporteTurnos.addActionListener(this);
        this.panelTablaReporteTurnos = new PanelTablaTurnosUI(paciente.getNombreUsuario(), paciente.getClass());
        this.panelOpciones.setLayout(new GridLayout(3,1));
    }
    
    @Override
    public void armar() {
        //Panel opciones
        this.panelOpciones.add(new JLabel("Listar turnos"));
        this.panelOpciones.add(this.botonReporteTurnos);
        
        //Frame principal
        this.add(this.panelOpciones);
        
        super.centrar();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonReporteTurnos){
            this.asignarUltimoPanel(this.panelTablaReporteTurnos);
                
            try {
                this.mostrarPanelTabla(this.panelTablaReporteTurnos);
            } catch (OperacionException ex) {
                AdministradorFrames.mostrarMensaje(ex.getMessage());
            }
        }
    }
}
