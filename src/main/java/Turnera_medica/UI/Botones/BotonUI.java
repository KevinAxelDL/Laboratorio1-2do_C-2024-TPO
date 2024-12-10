/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Botones;

import Turnera_medica.Excepciones.OperacionException;
import Turnera_medica.UI.Operaciones.Operacion;
import javax.swing.JButton;

/**
 *
 * @author KevinDL
 */
public class BotonUI extends JButton{
    private Operacion operacion;
    
    // Constructores
    public BotonUI(String texto){
        super.setText(texto);
    }
    
    public BotonUI(String texto, Operacion operacion){
        super.setText(texto);
    }
    
   // Operaciones
    public void setOperacion(Operacion operacion){
        this.operacion = operacion;
    }
    
    public void activar() throws OperacionException{
        this.operacion.realizar();
    }
}
