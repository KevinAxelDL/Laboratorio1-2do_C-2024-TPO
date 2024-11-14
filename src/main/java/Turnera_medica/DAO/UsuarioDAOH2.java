/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.DAO;

import Turnera_medica.BD.DBManager;
import Turnera_medica.DAO.Interfaces.UsuarioDAO;
import Turnera_medica.Excepciones.DAOException;
import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Modelo.Medico;
import Turnera_medica.Modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author KevinDL
 */
public class UsuarioDAOH2 implements UsuarioDAO{
    
    @Override
    public Usuario ingresarComoUsuario(String nombreUsuarioIn, String claveUsuarioIN) throws DAOException{
        String operacionSQL1 = "SELECT u.NOMBRE, APELLIDO, DNI, u.NOMBRE_USUARIO, CLAVE_USUARIO, f.NOMBRE AS NOMBRE_FUNCION \n" +
        "FROM USUARIO u JOIN ( SELECT * FROM USUARIO_POR_FUNCION JOIN FUNCION WHERE ID_FUNCION = ID )f\n" +
        "WHERE u.NOMBRE_USUARIO = '"+ nombreUsuarioIn +"' AND CLAVE_USUARIO = '"+ claveUsuarioIN +"' ";
        Connection conexion = DBManager.connect(); // Se abre una conexion con la BD
        ResultSet rs = null;
        Usuario resultado = null;
        
        try {
            Statement operacion = conexion.createStatement(); 
            rs = operacion.executeQuery(operacionSQL1);
            
            try {
                // Se instancia un usuario segun el result set
                if(rs.isBeforeFirst() == false){
                    // Verifica que haya un resultado
                    throw new DAOException("CREDENCIALES INCORRECTAS!");
                }
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
                    resultado = usuario;
                }
            } catch (SQLException ex) {                
                ex.printStackTrace();
                throw new DAOException("ERROR DESCONOCIDO");
            }
	} catch (SQLException e) {
            try {
		conexion.rollback();
		e.printStackTrace();
                 throw new DAOException("ERROR DESCONOCIDO!");
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
        
        
        return resultado;
    }
}
