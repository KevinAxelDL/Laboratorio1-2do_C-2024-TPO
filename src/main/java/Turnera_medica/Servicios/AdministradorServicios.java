/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.Servicios;

import Turnera_medica.DAO.AdministradorDAOH2;
import Turnera_medica.Excepciones.DAOException;
import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Modelo.Usuario;
import java.util.List;


/**
 *
 * @author KevinDL
 */
public abstract class AdministradorServicios {
    
    public static void registrarAdministrador(Administrador nuevoAdmin) throws ServicioException{
        AdministradorDAOH2 adminDAOH2 = new AdministradorDAOH2();
        
        try {
            adminDAOH2.registrarAdministrador(nuevoAdmin);
        } catch (DAOException ex) {
            throw new ServicioException(ex.getMessage());
        }
    }
    
    public static void eliminarAdministrador(String nUsuario) throws ServicioException{
        AdministradorDAOH2 adminDAOH2 = new AdministradorDAOH2();
        
        try {
            adminDAOH2.eliminarAdministrador(nUsuario);
        } catch (DAOException ex) {
            throw new ServicioException(ex.getMessage());
        }
    }
    
    public static List<Usuario> listarUsuariosConFuncion() throws ServicioException{
        AdministradorDAOH2 adminDAOH2 = new AdministradorDAOH2();
        List<Usuario> resultado;
        
        try {
            resultado = adminDAOH2.listarUsuariosConFuncion();
        } catch (DAOException ex) {
            throw new ServicioException(ex.getMessage());
        }
        
        return resultado;
    }
}
