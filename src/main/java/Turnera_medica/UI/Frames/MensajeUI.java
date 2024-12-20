/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Frames;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author KevinDL
 */
public class MensajeUI extends UserInterface{
    private JLabel mensajeLabel; 
    
    public MensajeUI(String mensaje){
        super("NOTIFICACION!");
        this.mensajeLabel = new JLabel(mensaje);
    }

    @Override
    public void armar() {
        // Se define el comportamiento del frame 
        this.setSize(400, 150);
        this.setLayout(new GridLayout(1, 1)); // 1 fila, 1 columna
        
        // Agrega los componentes
        this.add(mensajeLabel);

        // Hace visible el frame
        this.mensajeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.centrar();
        this.setVisible(true);
    }
}
