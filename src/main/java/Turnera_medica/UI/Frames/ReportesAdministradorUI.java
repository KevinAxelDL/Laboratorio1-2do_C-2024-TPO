/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;

import Turnera_medica.UI.Paneles.PanelTablaUsuariosUI;
import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.UI.Botones.BotonUI;
import Turnera_medica.UI.Frames.UserInterface;
import Turnera_medica.UI.Mediadores.AdministradorFrames;
import Turnera_medica.UI.Mediadores.AdministradorOperaciones;
import Turnera_medica.UI.Paneles.PanelIngresoFechaUI;
import Turnera_medica.UI.Paneles.PanelIngresoHoraUI;
import Turnera_medica.UI.Paneles.PanelIngresoStringUI;
import Turnera_medica.UI.Paneles.PanelTablaTurnosUI;
import Turnera_medica.UI.Paneles.PanelTablaUI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

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
    private PanelTablaTurnosUI panelTablaReporteTurnos;
    private JLabel tituloReporteUsuarios;
    private JLabel tituloReporteGanancias;
    private PanelIngresoHoraUI panelIngresoHora;
    private PanelIngresoFechaUI panelIngresoFecha;
    private PanelTablaUI ultimoPanelTabla;
    
    
    public ReportesAdministradorUI(){
        super("Reportes");
        this.setLayout(new GridLayout(1, 2));
        this.setSize(1500,900);
        
        this.panelTablaReporteUsuarios = new PanelTablaUsuariosUI();
        this.panelTablaReporteTurnos = new PanelTablaTurnosUI();
           
        this.botonReporteUsuarios = new BotonUI("Actualizar (1)");
        this.botonReporteUsuarios.addActionListener(this);
        
        this.panelIngresoFecha = new PanelIngresoFechaUI();
        this.botonReporteGanancias = new BotonUI("Actualizar (2)");
        this.botonReporteGanancias.addActionListener(this);
        
        this.botonReporteTurnos = new BotonUI("Actualizar (3)");
        this.botonReporteTurnos.addActionListener(this);
        
        this.panelOpciones = new JPanel(); 
        this.panelOpciones.setLayout(new GridLayout(8,1));
    }
    
    @Override
    public void armar() {
        //Panel ganancias; fechas y medico
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
        this.panelOpciones.add(new JLabel("Listar usuarios"));
        this.panelOpciones.add(this.botonReporteUsuarios);
        
        this.panelOpciones.add(new JLabel("Listar ganancias"));
        this.panelOpciones.add(panelFechas);
        this.panelOpciones.add(this.botonReporteGanancias);
        
        this.panelOpciones.add(new JLabel("Listar turnos"));
        this.panelOpciones.add(this.botonReporteTurnos);
        
        //Frame principal
        this.add(this.panelOpciones);
        
        super.centrar();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.botonReporteUsuarios){
            this.asignarUltimoPanel(this.panelTablaReporteUsuarios);
            
            try {
                this.mostrarPanelTabla(this.panelTablaReporteUsuarios);
            } catch (OperacionException ex) {
                AdministradorFrames.mostrarMensaje(ex.getMessage());
            }
        }
        
        if(e.getSource() == this.botonReporteTurnos){
            this.asignarUltimoPanel(this.panelTablaReporteTurnos);
                
            try {
                this.mostrarPanelTabla(this.panelTablaReporteTurnos);
            } catch (OperacionException ex) {
                AdministradorFrames.mostrarMensaje(ex.getMessage());
            }
        }
    }
    
    private void asignarUltimoPanel(PanelTablaUI panel){
        if(this.ultimoPanelTabla != null){
            this.remove(this.ultimoPanelTabla); 
        }
        this.ultimoPanelTabla = panel;
        this.revalidate();
        this.repaint();
    }
    
    private void mostrarPanelTabla(PanelTablaUI panel) throws OperacionException {
        //Obtencion de datos
        this.add(panel,0);
        panel.actualizar();
        this.revalidate();
        this.repaint();
    }
    
    
    
}
