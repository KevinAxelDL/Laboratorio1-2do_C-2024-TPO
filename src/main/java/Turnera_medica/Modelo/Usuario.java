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
    private int dni;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String claveUsuario;
    
    public static void ingresarAlSistema(String nUsuario, String cUsuario){
        // Metodo de clase
        // Loggeo en base a credenciales
    }
    
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
