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
    
    public Administrador(int dni, String nombre, String apellido, String nombreUsuario, String claveUsuario){
        super( dni,  nombre,  apellido,  nombreUsuario,  claveUsuario);
    }
    
    public String getNombreUsuario() {
        return super.nombreUsuario;
    }
    
    public String getClaveUsuario() {
        return super.claveUsuario;
    }

    @Override
    public String getNombreClase() {
        return "ADMINISTRADOR";
    }
    
}
