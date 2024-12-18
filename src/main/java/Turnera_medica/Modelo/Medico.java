/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.Modelo;

/**
 *
 * @author KevinDL
 */
public class Medico extends Usuario{
    public static double precioConsultaDefault = 1000;
    private double precioConsulta; 
    
    public Medico(int dni, String nombre, String apellido, String nombreUsuario, String claveUsuario){
        super( dni,  nombre,  apellido,  nombreUsuario,  claveUsuario);
        this.precioConsulta = Medico.precioConsultaDefault;
    }
    
    public Medico(int dni, String nombre, String apellido, String nombreUsuario, String claveUsuario, double precio){
        super( dni,  nombre,  apellido,  nombreUsuario,  claveUsuario);
        this.precioConsulta = precio;
    }
    
    public String getTipoUsuario(){
        return "MEDICO";
    }
    
    public void actualizarPrecioConsulta(double precio){
        this.precioConsulta = precio;
    }
    
    public double getPrecioConsulta(){
        return this.precioConsulta;
    }
}
