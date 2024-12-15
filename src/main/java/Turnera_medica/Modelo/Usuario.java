/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.Modelo;

/**
 *
 * @author KevinDL
 */
public class Usuario {
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

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }
    
}
