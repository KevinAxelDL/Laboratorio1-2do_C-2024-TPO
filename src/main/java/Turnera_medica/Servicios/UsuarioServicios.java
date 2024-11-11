/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.Servicios;

import Turnera_medica.DAO.UsuarioDAOH2;
import Turnera_medica.Excepciones.DAOException;
import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Modelo.Usuario;

/**
 *
 * @author KevinDL
 */
public abstract class UsuarioServicios {
    public static Usuario ingresarComoUsuario(String nombreUsuario, String claveUsuario) throws ServicioException{
        UsuarioDAOH2 userH2 = new UsuarioDAOH2();
        Usuario usuario = null;
        try {
            usuario = userH2.ingresarComoUsuario(nombreUsuario, claveUsuario);
        } catch (DAOException ex) {
            throw new ServicioException(ex.getMessage());
        }
        return usuario;
    }
}
