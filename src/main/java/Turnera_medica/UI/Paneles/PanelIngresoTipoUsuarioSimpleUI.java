/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Paneles;

import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Modelo.Medico;
import Turnera_medica.Modelo.Paciente;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author KevinDL
 */
public class PanelIngresoTipoUsuarioSimpleUI extends JPanel implements ActionListener{
    private JRadioButton opcion1;
    private JRadioButton opcion2;
    private JRadioButton opcion3;
    private ButtonGroup grupoDeOpciones;
    private Class<?> tipoSeleccionado;
    
    public PanelIngresoTipoUsuarioSimpleUI(){
        
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        this.opcion1 = new JRadioButton("PACIENTE");
        this.opcion2 = new JRadioButton("ADMINISTRADOR");
        this.opcion3 = new JRadioButton("MEDICO");
        
        this.opcion1.addActionListener(this);
        this.opcion2.addActionListener(this);
        this.opcion3.addActionListener(this);
        
        this.grupoDeOpciones = new ButtonGroup();
        this.grupoDeOpciones.add(this.opcion1);
        this.grupoDeOpciones.add(this.opcion2);
        this.grupoDeOpciones.add(this.opcion3); 

        this.add(opcion1);
        this.add(opcion2);
        this.add(opcion3);
    }
    
    public Class<?> getTipoSeleccionado(){
        return this.tipoSeleccionado;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.opcion1){
            this.tipoSeleccionado = Paciente.class;
        }
        
        if(e.getSource() == this.opcion2){
            this.tipoSeleccionado = Administrador.class;
        }
        
        if(e.getSource() == this.opcion3){
            this.tipoSeleccionado = Medico.class;
        }
    }
    
}
