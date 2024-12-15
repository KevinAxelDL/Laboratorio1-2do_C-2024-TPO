/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Paneles;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author KevinDL
 */
public class PanelIngresoFechaUI extends JPanel{
    public PanelIngresoFechaUI(){
        this.setLayout(new FlowLayout());

        JSpinner diaSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        diaSpinner.setPreferredSize(new Dimension(60, 30));

        JSpinner mesSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        mesSpinner.setPreferredSize(new Dimension(60, 30));

        JSpinner anioSpinner = new JSpinner(new SpinnerNumberModel(2024, 1900, 2100, 1));
        anioSpinner.setPreferredSize(new Dimension(80, 30));

        this.add(new JLabel("Dia:"));
        this.add(diaSpinner);
        this.add(new JLabel("Mes:"));
        this.add(mesSpinner);
        this.add(new JLabel("Año:"));
        this.add(anioSpinner);
    }
}
