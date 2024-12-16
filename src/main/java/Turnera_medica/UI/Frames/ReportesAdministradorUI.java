/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;

import Turnera_medica.UI.Paneles.PanelTablaUsuariosUI;
import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.UI.Botones.BotonUI;
import Turnera_medica.UI.Operaciones.ActualizarPanelTablaUsuariosOperacion;
import Turnera_medica.UI.Frames.UserInterface;
import Turnera_medica.UI.Mediadores.AdministradorFrames;
import Turnera_medica.UI.Paneles.PanelIngresoFechaUI;
import Turnera_medica.UI.Paneles.PanelIngresoHoraUI;
import Turnera_medica.UI.Paneles.PanelIngresoStringUI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author KevinDL
 */
public class ReportesAdministradorUI extends UserInterface implements ActionListener{
    private JPanel panelOpciones;
    private BotonUI botonReporteUsuarios;
    private BotonUI botonReporteTurnos;
    private BotonUI botonReporteGanancias;
    private PanelTablaUsuariosUI panelTablaReporteUsuarios;
    private JLabel tituloReporteUsuarios;
    private JLabel tituloReporteGanancias;
    private PanelIngresoHoraUI panelIngresoHora;
    private PanelIngresoFechaUI panelIngresoFecha;
    
    
    public ReportesAdministradorUI(){
        super("Reportes");
        this.setLayout(new GridLayout(1, 2));
        this.setSize(1500,900);
        
        this.panelTablaReporteUsuarios = new PanelTablaUsuariosUI();    
           
        this.tituloReporteUsuarios = new JLabel("Listar usuarios");
        this.botonReporteUsuarios = new BotonUI("Actualizar (1)");
        this.botonReporteUsuarios.addActionListener(this);
        
        this.tituloReporteGanancias = new JLabel("Listar ganancias");
        this.panelIngresoFecha = new PanelIngresoFechaUI();
        this.botonReporteGanancias = new BotonUI("Actualizar (2)");
        this.botonReporteGanancias.addActionListener(this);
        
        this.botonReporteTurnos = new BotonUI("Actualizar (3)");
        
        this.panelOpciones = new JPanel(); 
        this.panelOpciones.setLayout(new GridLayout(8,1));
    }
    
    @Override
    public void armar() {
        //Panel ganancias fechas y medico
        JPanel panelFechas = new JPanel();
        
        panelFechas.setLayout(new GridLayout(3,2));
        JLabel tituloInicio = new JLabel("Desde: ");
        JLabel tituloFinal = new JLabel("Hasta: ");
        
        PanelIngresoFechaUI fechaInicio = new PanelIngresoFechaUI();
        PanelIngresoFechaUI fechaFin = new PanelIngresoFechaUI();
        
        PanelIngresoStringUI panelString = new PanelIngresoStringUI();
        JLabel tituloUsuaruio = new JLabel("Ingrese un usuario: ");
        
        panelFechas.add(tituloInicio);
        panelFechas.add(fechaInicio);
        panelFechas.add(tituloFinal);
        panelFechas.add(fechaFin);
        panelFechas.add(tituloUsuaruio);
        panelFechas.add(panelString);
        
        //Panel opciones
        this.panelOpciones.add(this.tituloReporteUsuarios);
        this.panelOpciones.add(this.botonReporteUsuarios);
        
        this.panelOpciones.add(this.tituloReporteGanancias);
        this.panelOpciones.add(panelFechas);
        this.panelOpciones.add(this.botonReporteGanancias);
        
        JLabel tituloReporteTurnos = new JLabel("Listar turnos");
        this.panelOpciones.add(tituloReporteTurnos);
        this.panelOpciones.add(this.botonReporteTurnos);
        
        //Frame principal
        this.add(this.panelTablaReporteUsuarios);
        this.add(this.panelOpciones);
        
        super.centrar();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonReporteUsuarios){
            ActualizarPanelTablaUsuariosOperacion operacion = new ActualizarPanelTablaUsuariosOperacion(this.panelTablaReporteUsuarios);
            this.botonReporteUsuarios.setOperacion(operacion);
            try {
                this.botonReporteUsuarios.activar();
            } catch (OperacionException ex) {
            AdministradorFrames.mostrarMensaje(ex.getMessage());
            }
        }
    }
    
    
    
}
