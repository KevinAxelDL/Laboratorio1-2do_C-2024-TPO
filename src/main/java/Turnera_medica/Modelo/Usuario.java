/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.Modelo;

/**
 *
 * @author KevinDL
 */
public abstract class Usuario {
    // Para que las subclases puedan acceder a sus atributos la visibilidad se definira como "protected"
    protected int dni;
    protected String nombre;
    protected String apellido;
    protected String nombreUsuario;
    protected String claveUsuario;
    
    public Usuario(int dni, String nombre, String apellido, String nombreUsuario, String claveUsuario){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.claveUsuario = claveUsuario;
    }
    
    public Usuario(String nombreUsuario, String claveUsuario){
        this.nombreUsuario = nombreUsuario;
        this.claveUsuario = claveUsuario;
    }
    
}
