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
import Turnera_medica.UI.Paneles.PanelTablaGananciasUI;
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
public class ReportesAdministradorUI extends ReportesUI{
    
    private BotonUI botonReporteUsuarios;
    private BotonUI botonReporteTurnos;
    private BotonUI botonReporteGanancias;
    
    private PanelTablaUsuariosUI panelTablaReporteUsuarios;
    private PanelTablaTurnosUI panelTablaReporteTurnos;
    private PanelTablaGananciasUI panelTablaReporteGanancias;
    
    private JPanel panelFechas;
    private PanelIngresoFechaUI panelIngresoFechaInicial;
    private PanelIngresoFechaUI panelIngresoFechaFinal;
    private PanelIngresoStringUI panelIngresoString;
    
    
    public ReportesAdministradorUI(){
        super();
        
        this.panelTablaReporteUsuarios = new PanelTablaUsuariosUI();
        this.panelTablaReporteTurnos = new PanelTablaTurnosUI();
        this.panelTablaReporteGanancias = new PanelTablaGananciasUI();
           
        this.botonReporteUsuarios = new BotonUI("Actualizar (1)");
        this.botonReporteUsuarios.addActionListener(this);
        
        //Panel ganancias; fechas y medico
        this.panelFechas = new JPanel();//Principal
        this.panelFechas.setLayout(new GridLayout(3,2));
        
        this.panelIngresoFechaInicial = new PanelIngresoFechaUI();
        this.panelIngresoFechaFinal = new PanelIngresoFechaUI();
        this.panelIngresoString = new PanelIngresoStringUI();
        
        
        this.botonReporteGanancias = new BotonUI("Actualizar (2)");
        this.botonReporteGanancias.addActionListener(this);
        //
        this.botonReporteTurnos = new BotonUI("Actualizar (3)");
        this.botonReporteTurnos.addActionListener(this);
        
        this.panelOpciones.setLayout(new GridLayout(8,1));
    }
    
    @Override
    public void armar() {
        //Panel ganancias; fechas y medico
        
        panelFechas.add(new JLabel("Desde: "));
        panelFechas.add(this.panelIngresoFechaInicial);
        panelFechas.add(new JLabel("Hasta: "));
        panelFechas.add(this.panelIngresoFechaFinal);
        panelFechas.add(new JLabel("Ingrese un usuario: "));
        panelFechas.add(this.panelIngresoString);
        
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
        
        if(e.getSource() == this.botonReporteGanancias){
            //Se asignan los valores ingresados en la UI
            this.panelTablaReporteGanancias.setFechaDesde(this.panelIngresoFechaInicial.toString());
            this.panelTablaReporteGanancias.setFechaHasta(this.panelIngresoFechaFinal.toString());
            this.panelTablaReporteGanancias.setUsuarioMedico(this.panelIngresoString.getTexto());
            
            this.asignarUltimoPanel(this.panelTablaReporteGanancias);
                
            try {
                this.mostrarPanelTabla(this.panelTablaReporteGanancias);
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
}
