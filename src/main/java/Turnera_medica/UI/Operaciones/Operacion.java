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
public interface Operacion {
    //  Define una accion a realizar
    public Object realizar() throws OperacionException;
}
