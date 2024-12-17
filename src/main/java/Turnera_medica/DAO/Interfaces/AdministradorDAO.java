/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.DAO.Interfaces;

import Turnera_medica.Excepciones.DAOException;
import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Modelo.Turno;
import Turnera_medica.Modelo.Usuario;
import java.util.List;

/**
 *
 * @author KevinDL
 */
public interface AdministradorDAO{
    
    // Dar de alta registro
    public void registrarUsuario(Usuario nuevoUsuario, Object[] seleccionTipoUsuario) throws DAOException;
    
    public void registrarTurno(Turno nuevoTurno) throws DAOException;
    
    // Dar de baja registro
    public int eliminarUsuario(String nUsuario)throws DAOException;;
    
    // Consultas
    public List<Usuario> listarUsuariosConFuncion() throws DAOException;
    
    public List<Usuario> listarUsuariosConFuncion(String nombreUsuarioBuscado) throws DAOException;
    
    public List<Turno> listarTurnos() throws ServicioException;
    
    // Modificar registro
    public void asignarFuncionAdministrador(Usuario usuario) throws DAOException;
    
    
}
