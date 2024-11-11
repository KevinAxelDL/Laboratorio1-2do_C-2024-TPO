/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.DAO;

import Turnera_medica.BD.DBManager;
import Turnera_medica.DAO.Interfaces.AdministradorDAO;
import Turnera_medica.Excepciones.DAOException;
import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Modelo.Medico;
import Turnera_medica.Modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KevinDL
 */

public class AdministradorDAOH2 implements AdministradorDAO {

    @Override
    public void registrarAdministrador(Administrador nuevoAdmin) throws DAOException{
        String operacionSQLAux1 = "SELECT ID FROM FUNCION WHERE NOMBRE = 'ADMINISTRADOR'";
        String operacionSQL1 = "INSERT INTO USUARIO (NOMBRE_USUARIO, CLAVE_USUARIO) VALUES ('"+ nuevoAdmin.getNombreUsuario() +"','"+ nuevoAdmin.getClaveUsuario() +"')";
        String operacionSQL2 = "INSERT INTO USUARIO_POR_FUNCION (NOMBRE_USUARIO, ID_FUNCION) VALUES ('"+ nuevoAdmin.getNombreUsuario() +"',("+ operacionSQLAux1 +"))";
        Connection conexion = DBManager.connect(); // Se abre una conexion con la BD
        
        try {
            Statement operacion = conexion.createStatement(); 
            operacion.execute(operacionSQL1); // Ejecuta la operacion, crea usuario
            operacion.execute(operacionSQL2); // Ejecuta la operacion, asocia una funcion al usuario
            conexion.commit(); // Aplica los cambios an la BD
	} catch (SQLException e) {
            try {
		conexion.rollback();
		e.printStackTrace();
                if(e.getErrorCode() == 23505){
                    throw new DAOException("EL USUARIO O DESIGNACION DE FUNCION YA EXISTE");
                }else{
                    throw new DAOException("ERROR DESCONOCIDO");
                }
            } catch (SQLException e1) {
		e1.printStackTrace();
            }
        } finally {
            try {
                conexion.close(); // Se CIERRA la conexion para liberar el acceso
            } catch (SQLException e) {
		e.printStackTrace();
            }
        }	
    }

    @Override
    public void eliminarAdministrador(String nUsuario) throws DAOException{
        String operacionSQL1 = "DELETE FROM USUARIO_POR_FUNCION WHERE NOMBRE_USUARIO = '"+ nUsuario +"';";
        String operacionSQL2 = "DELETE FROM USUARIO WHERE NOMBRE_USUARIO = '"+ nUsuario +"';";
        Connection conexion = DBManager.connect(); // Se abre una conexion con la BD
        
        try {
            Statement operacion = conexion.createStatement(); 
            operacion.execute(operacionSQL1); // Ejecuta la operacion, elimina en tabla
            operacion.execute(operacionSQL2); // Ejecuta la operacion, elimina en tabla
            conexion.commit(); // Aplica los cambios an la BD
	} catch (SQLException e) {
            try {
		conexion.rollback();
		e.printStackTrace();
                throw new DAOException("ERROR DESCONOCIDO");
            } catch (SQLException e1) {
		e1.printStackTrace();
            }
        } finally {
            try {
                conexion.close(); // Se CIERRA la conexion para liberar el acceso
            } catch (SQLException e) {
		e.printStackTrace();
            }
        }
    }
    
    @Override
    public List<Usuario> listarUsuariosConFuncion() throws DAOException {
        String operacionSQL1 = "SELECT u.NOMBRE, APELLIDO, DNI, u.NOMBRE_USUARIO, CLAVE_USUARIO, f.NOMBRE AS NOMBRE_FUNCION FROM USUARIO u JOIN USUARIO_POR_FUNCION uf JOIN FUNCION f";
        Connection conexion = DBManager.connect(); // Se abre una conexion con la BD
        ResultSet rs = null;
        List<Usuario> resultado = new ArrayList();
        
        try {
            Statement operacion = conexion.createStatement(); 
            rs = operacion.executeQuery(operacionSQL1); 
	} catch (SQLException e) {
            try {
		conexion.rollback();
		e.printStackTrace();
                throw new DAOException("ERROR DESCONOCIDO");
            } catch (SQLException e1) {
		e1.printStackTrace();
            }
        } finally {
            try {
                conexion.close(); // Se CIERRA la conexion para liberar el acceso
            } catch (SQLException e) {
		e.printStackTrace();
            }
        }
        
        try {
            // Se instancian usuarios en base al result set retornado
            while(rs.next()){
                String nombre = rs.getString("NOMBRE");
                String apellido = rs.getString("APELLIDO");
                int dni = rs.getInt("DNI");
                String nombreUsuario = rs.getString("NOMBRE_USUARIO");
                String claveUsuario = rs.getString("CLAVE_USUARIO");
                Usuario usuario = null;
                
                switch(rs.getString("NOMBRE_FUNCION")){
                    case "MEDICO":
                        usuario = new Medico( dni, nombre, apellido, nombreUsuario, claveUsuario);
                        break;
                    case "ADMINISTRADOR":
                        usuario = new Administrador( dni, nombre, apellido, nombreUsuario, claveUsuario);
                        break;
                    case "PACIENTE":
                        usuario = new Administrador( dni, nombre, apellido, nombreUsuario, claveUsuario);
                        break;
                }
                resultado.add(usuario);
            }
        } catch (SQLException ex) {                    
            throw new DAOException("ERROR DESCONOCIDO");
        }
        return resultado;
    }
}
