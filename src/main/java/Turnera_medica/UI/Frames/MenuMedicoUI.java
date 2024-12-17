/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;

import Turnera_medica.Modelo.Medico;
import Turnera_medica.UI.Botones.BotonUI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

/**
 *
 * @author KevinDL
 */
public class MenuMedicoUI extends MenuUI{
    private BotonUI botonMostrarReportes;
    
    public MenuMedicoUI(Medico medico){
        super("Menu medico", medico);
        super.configurarPorDefault();
        this.setLayout(new GridLayout(3,1));
        this.botonMostrarReportes = new BotonUI("Reportes");
    }
    
    @Override
    public void armar() {
        super.armar();
        this.centrar();
        this.botonMostrarReportes.addActionListener(this);
        this.add(this.botonMostrarReportes);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonMostrarReportes){
            
        }
    }
    
}
