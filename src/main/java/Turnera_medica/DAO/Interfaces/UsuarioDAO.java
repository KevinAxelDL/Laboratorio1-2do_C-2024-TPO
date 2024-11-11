/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.DAO.Interfaces;

import Turnera_medica.Excepciones.DAOException;
import Turnera_medica.Modelo.Usuario;

/**
 *
 * @author KevinDL
 */
public interface UsuarioDAO {
    
    // Ingreso
    public Usuario ingresarComoUsuario(String nombreUsuarioIn, String claveUsuarioIN) throws DAOException;
}
