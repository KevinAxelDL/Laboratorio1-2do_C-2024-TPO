/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.Operaciones;

import Turnera_medica.Excepciones.OperacionException;

/**
 *
 * @author KevinDL
 */
public abstract class OperacionSobreUsuario extends Operacion{
    protected String usuario;

    public OperacionSobreUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public OperacionSobreUsuario(){
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public abstract Object realizar() throws OperacionException; // Ejecuta la operacion
}
