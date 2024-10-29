/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.DAO.Interfaces;

import Turnera_medica.Modelo.Medico;

/**
 *
 * @author KevinDL
 */
public interface MedicoDAO extends UsuarioDAO {
    
    // Creacion
    public void crear(String nombre, String apellido, int dni, String nomUsuario, String passUsuario, double valorTurno);
    public void crear(String nombreUsuario, String passUsuario, double valorTurno);
    public void crear(String nombreUsuario, String passUsuario);
    
    // Actualizacion
    public void actualizar(Medico medico, double valorTurno);
    
    // Eliminacion
    public void eliminar(Medico medico);
}
