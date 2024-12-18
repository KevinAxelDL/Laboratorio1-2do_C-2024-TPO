/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.UI.Paneles.PanelTablaUI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author KevinDL
 */
public abstract class ReportesUI extends UserInterface implements ActionListener{
    protected JPanel panelOpciones;
    private PanelTablaUI ultimoPanelTabla;
    
    public ReportesUI(){
        super("Reportes");
        this.setLayout(new GridLayout(1, 2));
        this.setSize(1500,900);
        this.panelOpciones = new JPanel(); 
    }
    
    protected void asignarUltimoPanel(PanelTablaUI panel){
        if(this.ultimoPanelTabla != null){
            this.remove(this.ultimoPanelTabla); 
        }
        this.ultimoPanelTabla = panel;
        this.revalidate();
        this.repaint();
    }
    
    protected void mostrarPanelTabla(PanelTablaUI panel) throws OperacionException {
        this.add(panel,0);
        panel.actualizar();//Obtencion de datos
        this.revalidate();
        this.repaint();
    }
    
}


