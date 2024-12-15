/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Paneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author KevinDL
 */
public class PanelIngresoHoraUI extends JPanel{
    private SpinnerNumberModel modeloHora;
    private JSpinner spinnerHora;
    private SpinnerNumberModel modeloMinuto;
    private JSpinner spinnerMinuto;
    
    public PanelIngresoHoraUI(){
        
        SpinnerNumberModel modeloHora = new SpinnerNumberModel(12, 0, 23, 1);
        this.spinnerHora = new JSpinner(modeloHora);

        SpinnerNumberModel modeloMinuto = new SpinnerNumberModel(0, 0, 59, 1);
        this.spinnerMinuto = new JSpinner(modeloMinuto);
        
        this.setLayout(new FlowLayout());
        this.add(new JLabel("Horas:"));
        this.add(spinnerHora);
        this.add(new JLabel("Minutos:"));
        this.add(spinnerMinuto);
    }
    
    public String getHora(){
        return (String) this.modeloHora.getValue();
    }
    
    public String getMinutos(){
        return (String) this.modeloMinuto.getValue();
    }
        
}
