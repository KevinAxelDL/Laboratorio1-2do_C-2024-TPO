/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.DAO.Interfaces;

import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Modelo.Medico;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author KevinDL
 */
public interface AdministradorDAO extends UsuarioDAO{
    // IMPORTENTE: como minimo debe crearse manualmente un Administrador en la BD (root)
    
    //Dar de alta
    public void registrarAdministrador(Administrador nuevoAdmin);
    
    //Dar de baja
    public void eliminarAdministrador(String nUsuario, String uClave);

    //Reportes
    //public String pedirReporteGanancias(Medico m, LocalDate d, LocalTime t);
    //public String pedirReporteGanancias(LocalDate d, LocalTime t);
    //public String pedirReporteGanancias(); 
}
