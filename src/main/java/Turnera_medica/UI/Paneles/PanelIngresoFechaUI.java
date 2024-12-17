/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Paneles;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author KevinDL
 */
public class PanelIngresoFechaUI extends JPanel{
    private JSpinner diaSpinner;
    private JSpinner mesSpinner;
    private JSpinner anioSpinner;
    
    public PanelIngresoFechaUI(){
        this.setLayout(new FlowLayout());

        this.diaSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        this.diaSpinner.setPreferredSize(new Dimension(60, 30));

        this.mesSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        this.mesSpinner.setPreferredSize(new Dimension(60, 30));

        this.anioSpinner = new JSpinner(new SpinnerNumberModel(2024, 1900, 2100, 1));
        this.anioSpinner.setPreferredSize(new Dimension(80, 30));

        this.add(new JLabel("Dia:"));
        this.add(this.diaSpinner);
        this.add(new JLabel("Mes:"));
        this.add(this.mesSpinner);
        this.add(new JLabel("Año:"));
        this.add(this.anioSpinner);
    }

    public Object getDia() {
        return diaSpinner.getValue();
    }

    public Object getMes() {
        return mesSpinner.getValue();
    }

    public Object getAnio() {
        return anioSpinner.getValue();
    }
    
    public String toString(){
        return this.getAnio().toString()+ "-" + this.getMes().toString() + "-" + this.getDia().toString();
    }
    
    
}
