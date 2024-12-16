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
import Turnera_medica.Modelo.Paciente;
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
    public Usuario ingresarComoUsuario(String nombreUsuarioIn, String claveUsuarioIN, Class<?> tipoClase) throws DAOException{
        String operacionSQL1 = "SELECT u.NOMBRE, APELLIDO, DNI, u.NOMBRE_USUARIO, CLAVE_USUARIO, f.NOMBRE AS NOMBRE_FUNCION \n" +
                               "FROM USUARIO u JOIN ( SELECT * \n" +
                                                     "FROM USUARIO_POR_FUNCION uf JOIN FUNCION WHERE ID_FUNCION = ID AND uf.NOMBRE_USUARIO = '"+nombreUsuarioIn+"')f\n" +
                               "WHERE u.NOMBRE_USUARIO = '"+nombreUsuarioIn+"' AND CLAVE_USUARIO = '"+claveUsuarioIN+"'";
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
                while(rs.next() && resultado == null){
                    String nombre = rs.getString("NOMBRE");
                    String apellido = rs.getString("APELLIDO");
                    int dni = rs.getInt("DNI");
                    String nombreUsuario = rs.getString("NOMBRE_USUARIO");
                    String claveUsuario = rs.getString("CLAVE_USUARIO");
                    Usuario usuario = null;
                    
                    //Se define que tipo de usuario se instanciara
                    if(tipoClase == Administrador.class && rs.getString("NOMBRE_FUNCION").equals("ADMINISTRADOR")){
                        usuario = new Administrador( dni, nombre, apellido, nombreUsuario, claveUsuario);
                        resultado = usuario;
                    }else{
                        System.out.println(tipoClase);
                        System.out.println(Medico.class);
                        System.out.println(rs.getString("NOMBRE_FUNCION"));
                        if(tipoClase == Medico.class && rs.getString("NOMBRE_FUNCION").equals("MEDICO")){
                            usuario = new Medico( dni, nombre, apellido, nombreUsuario, claveUsuario);
                            resultado = usuario;
                        }else{
                            if(tipoClase == Paciente.class && rs.getString("NOMBRE_FUNCION").equals("PACIENTE")){
                                usuario = new Paciente( dni, nombre, apellido, nombreUsuario, claveUsuario);
                                resultado = usuario;
                            }
                        }
                    } 
                }
                if(resultado == null){
                    // Tipo de usuario invalido
                    throw new DAOException("TIPO DE USUARIO INCORRECTO!");
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
