/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI;

import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Servicios.AdministradorServicios;

/**
 *
 * @author KevinDL
 */
public class CoordinadorUI {
    public CoordinadorUI(){
    }
    
    public void registrarAdministrador(String nUsuario, String uClave){
        Administrador nuevoAdmin = new Administrador(nUsuario, uClave); //Nueva instancia
        try {
            AdministradorServicios.registrarAdministrador(nuevoAdmin);
        } catch (ServicioException ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminarAdministrador (String nUsuario){
        try {
            AdministradorServicios.eliminarAdministrador(nUsuario);
        } catch (ServicioException ex) {
            ex.printStackTrace();
        }
    }
    
    public void ingresarAlSistema(String nUsuario, String cUsuario){
        // Metodo de clase
        // Loggeo en base a credenciales
    }
}
