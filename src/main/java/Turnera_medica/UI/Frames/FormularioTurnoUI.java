/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.UI.Botones.BotonUI;
import Turnera_medica.UI.Mediadores.AdministradorFrames;
import Turnera_medica.UI.Mediadores.AdministradorOperaciones;
import Turnera_medica.UI.Paneles.PanelIngresoFechaUI;
import Turnera_medica.UI.Paneles.PanelIngresoHoraUI;
import Turnera_medica.UI.Paneles.PanelIngresoStringUI;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author KevinDL
 */
public class FormularioTurnoUI extends UserInterface implements ActionListener{
    private JPanel panelMedico;
    private JPanel panelPaciente;
    private JPanel panelFechayHora;
    private JPanel panelConsultorio;
    private BotonUI botonEnvio;
    private PanelIngresoStringUI panelStringMedico;
    private PanelIngresoStringUI panelStringPaciente;
    private PanelIngresoStringUI panelStringConsultorio;
    private PanelIngresoFechaUI panelFecha;
    private PanelIngresoHoraUI panelHora;
    
    public FormularioTurnoUI(){
        super("Cargar turno medico");
        
        // Se define el comportamiento del frame 
        this.setLayout(new GridLayout(5, 1));
        
        //Paneles
        this.panelMedico = new JPanel();
        this.panelPaciente = new JPanel();
        this.panelFechayHora = new JPanel();
        this.panelConsultorio = new JPanel();
        this.botonEnvio = new BotonUI("Cargar");
        
        this.panelFecha = new PanelIngresoFechaUI();
        this.panelHora = new PanelIngresoHoraUI();
        this.panelStringMedico = new PanelIngresoStringUI();
        this.panelStringPaciente = new PanelIngresoStringUI();
        this.panelStringConsultorio = new PanelIngresoStringUI();
        
        this.panelMedico.setLayout(new FlowLayout());
        this.panelPaciente.setLayout(new FlowLayout());
        this.panelFechayHora.setLayout(new GridLayout(2,1));
        this.botonEnvio.setLayout(new FlowLayout());  
        this.panelConsultorio.setLayout(new FlowLayout());
        
        this.setSize(650, 400);
    }
    
    @Override
    public void armar() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.panelMedico.add(new JLabel("Ingrese un medico (usuario): "));
        this.panelMedico.add(this.panelStringMedico);
        
        this.panelPaciente.add(new JLabel("Ingrese un paciente (usuario)"));
        this.panelPaciente.add(this.panelStringPaciente);
        
        this.panelFechayHora.add(new JLabel("Fecha: "));
        this.panelFechayHora.add(this.panelFecha);
        this.panelFechayHora.add(new JLabel("Hora: "));
        this.panelFechayHora.add(this.panelHora);
        
        this.panelConsultorio.add(new JLabel("Ingrese un consultorio"));
        this.panelConsultorio.add(this.panelStringConsultorio);
        
        this.botonEnvio.addActionListener(this);
        
        this.add(this.panelMedico);
        this.add(this.panelPaciente);
        this.add(this.panelFechayHora);
        this.add(this.panelConsultorio);
        this.add(this.botonEnvio);
        
        this.centrar();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonEnvio){
            String fechaYHora;
            fechaYHora = this.panelFecha.toString() + " " +this.panelHora.toString();
            try {
                AdministradorOperaciones.registrarNuevoTurno(this.panelStringMedico.getTexto(), this.panelStringPaciente.getTexto(), fechaYHora, this.panelStringConsultorio.getTexto());
                AdministradorFrames.mostrarMensaje("TURNO REGISTRADO EXITOSAMENTE!");
            } catch (OperacionException ex) {
                AdministradorFrames.mostrarMensaje(ex.getMessage());
            }
        }
    }
    
}
