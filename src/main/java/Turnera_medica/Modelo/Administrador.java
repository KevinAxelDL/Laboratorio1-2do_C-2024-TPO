/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.Modelo;

import Turnera_medica.Servicios.AdministradorServicios;

/**
 *
 * @author KevinDL
 */
public class Administrador extends Usuario{
    
    public Administrador(String nUsuario, String uClave){
        super(nUsuario, uClave);
    }
    
    public void registrarAdministrador(String nUsuario, String uClave){
        Administrador nuevoAdmin = new Administrador(nUsuario, uClave); //Nueva instancia
        AdministradorServicios.registrarAdministrador(nuevoAdmin);
    }

    public String getNombreUsuario() {
        return super.nombreUsuario;
    }
    
    public String getClaveUsuario() {
        return super.claveUsuario;
    }
    
}
