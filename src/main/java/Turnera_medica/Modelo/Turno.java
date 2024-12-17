/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.Modelo;

/**
 *
 * @author KevinDL
 */
public class Turno {
    private Medico medico;
    private Paciente paciente;
    private String fechaYHora;
    private int consultorio;
    private double precio;
    
    public Turno(Medico medico, Paciente paciente, String fechaYHora, int consultorio){
        this.medico = medico;
        this.paciente = paciente;
        this.fechaYHora = fechaYHora;
        this.consultorio = consultorio;
        this.precio = medico.getPrecioConsulta();
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getFechaYHora() {
        return fechaYHora;
    }

    public int getConsultorio() {
        return consultorio;
    }

    public double getPrecio() {
        return precio;
    }
    
    
    
    
}
