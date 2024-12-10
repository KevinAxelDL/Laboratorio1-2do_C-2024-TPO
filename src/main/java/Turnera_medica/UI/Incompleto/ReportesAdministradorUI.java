/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Incompleto;

import Turnera_medica.UI.Paneles.PanelTablaUsuariosUI;
import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.UI.Botones.BotonUI;
import Turnera_medica.UI.Operaciones.ActualizarPanelTablaUsuariosOperacion;
import Turnera_medica.UI.Frames.UserInterface;
import Turnera_medica.UI.Mediadores.AdministradorFrames;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author KevinDL
 */
public class ReportesAdministradorUI extends UserInterface implements ActionListener{
    private JPanel panelOpciones;
    private BotonUI botonReporteUsuarios;
    private BotonUI botonReporteTurnos;
    private BotonUI botonReporteMedicos;
    private PanelTablaUsuariosUI panelReporteUsuarios;
    
    
    public ReportesAdministradorUI(){
        super("Reportes");
        super.framePrincipal.setLayout(new GridLayout(1, 2));
        super.framePrincipal.setSize(1500,500);
        
        this.panelReporteUsuarios = new PanelTablaUsuariosUI();    
           
        this.botonReporteUsuarios = new BotonUI("Actualizar");
        this.botonReporteUsuarios.addActionListener(this);
        
        this.panelOpciones = new JPanel(); 
        this.panelOpciones.setLayout(new GridLayout(6, 1));
        
    }
    
    @Override
    public void armar() {
        this.panelOpciones.add(this.botonReporteUsuarios);
        
        super.framePrincipal.add(this.panelReporteUsuarios);
        super.framePrincipal.add(this.panelOpciones);
        
        super.centrar();
        super.framePrincipal.setVisible(true);
        
        ;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonReporteUsuarios){
            ActualizarPanelTablaUsuariosOperacion operacion = new ActualizarPanelTablaUsuariosOperacion(this.panelReporteUsuarios);
            this.botonReporteUsuarios.setOperacion(operacion);
            try {
                this.botonReporteUsuarios.activar();
            } catch (OperacionException ex) {
            AdministradorFrames.mostrarMensaje(ex.getMessage());
            }
        }
        //super.framePrincipal.revalidate();
        //super.framePrincipal.repaint();
    }
    
    
    
}
