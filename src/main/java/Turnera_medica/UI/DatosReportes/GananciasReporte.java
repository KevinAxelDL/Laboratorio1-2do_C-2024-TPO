/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.UI.DatosReportes;

import Turnera_medica.Modelo.Medico;

/**
 *
 * @author KevinDL
 */
public class GananciasReporte {
    private Medico medico;
    private int cantTurnos;
    private String fechaDesde;
    private String fechaHasta;
    private double gananciaTotal;
    
    public GananciasReporte(Medico medico, int cantTurnos, String fechaDesde, String fechaHasta, double gananciaTotal){
        this.medico = medico;
        this.cantTurnos = cantTurnos;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.gananciaTotal = gananciaTotal;
    }

    public Medico getMedico() {
        return medico;
    }

    public int getCantTurnos() {
        return cantTurnos;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public double getGananciaTotal() {
        return gananciaTotal;
    }
    
    
    
}
