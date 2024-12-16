/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Paneles;

import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Modelo.Medico;
import Turnera_medica.Modelo.Paciente;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 *
 * @author KevinDL
 */
public class PanelIngresoTipoUsuarioUI extends JPanel implements ActionListener{
    private List<Class<?>> opcionesSeleccionadas;
    private Class<?> administradorSeleccionado = null;
    private Class<?> medicoSeleccionado = null;
    private Class<?> pacienteSeleccionado = null;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    
    public PanelIngresoTipoUsuarioUI(){
        this.checkBox1 = new JCheckBox("ADMINISTRADOR");
        this.checkBox2 = new JCheckBox("MEDICO");
        this.checkBox3 = new JCheckBox("PACIENTE");
        
        this.setLayout(new GridLayout(1,3));
        this.add(this.checkBox1);
        this.add(this.checkBox2);
        this.add(this.checkBox3);
        
        this.opcionesSeleccionadas = new ArrayList();
        
        this.checkBox1.addActionListener(this);
        this.checkBox2.addActionListener(this);
        this.checkBox3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.checkBox1){// ADMINISTRADOR
            if(this.checkBox1.isSelected()){
                this.administradorSeleccionado = Administrador.class;
            }else{
                this.administradorSeleccionado = null;
            }
        }
        
        if(e.getSource() == this.checkBox2){// MEDICO
            if(this.checkBox2.isSelected()){
                this.medicoSeleccionado = Medico.class;
            }else{
                this.medicoSeleccionado = null;
            }
        }
        
        if(e.getSource() == this.checkBox3){// PACIENTE
            if(this.checkBox3.isSelected()){
                this.pacienteSeleccionado = Paciente.class;
            }else{
                this.pacienteSeleccionado = null;
            }
        }
    }

    public List<Class<?>> getOpcionesSeleccionadas() {
        this.opcionesSeleccionadas.clear();// Elimina todos los elementos de la seleccion antetior
        this.opcionesSeleccionadas.add(this.administradorSeleccionado);
        this.opcionesSeleccionadas.add(this.medicoSeleccionado);
        this.opcionesSeleccionadas.add(this.pacienteSeleccionado);
        return this.opcionesSeleccionadas;
    }

    
    
}
