/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.DAO.Interfaces;

import Turnera_medica.Excepciones.DAOException;
import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Modelo.Usuario;
import java.util.List;

/**
 *
 * @author KevinDL
 */
public interface AdministradorDAO{
    
    // Dar de alta registro
    public void registrarAdministrador(Administrador nuevoAdmin) throws DAOException;
    
    // Dar de baja registro
    public int eliminarAdministrador(String nUsuario)throws DAOException;;
    
    // Consultas
    public List<Usuario> listarUsuariosConFuncion() throws DAOException;
    
    // Modificar registro
    
    
}
