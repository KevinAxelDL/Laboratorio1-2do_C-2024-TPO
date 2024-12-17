/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.DAO;

import Turnera_medica.BD.DBManager;
import Turnera_medica.DAO.Interfaces.AdministradorDAO;
import Turnera_medica.DAO.Utiles.HerramientasDAO;
import Turnera_medica.Excepciones.DAOException;
import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Modelo.Medico;
import Turnera_medica.Modelo.Paciente;
import Turnera_medica.Modelo.Turno;
import Turnera_medica.Modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KevinDL
 */

public class AdministradorDAOH2 implements AdministradorDAO {

    @Override
    public void registrarTurno(Turno nuevoTurno) throws DAOException {
        Timestamp fechaYHoraConvertida = HerramientasDAO.convertirATimeStamp(nuevoTurno.getFechaYHora()); 
        
        String operacionSQL1 = "INSERT INTO TURNO( USUARIO_MEDICO, USUARIO_PACIENTE, FECHA_Y_HORA, CONSULTORIO, PRECIO)\n" +
        "VALUES ('"+ nuevoTurno.getMedico().getNombreUsuario() +"', '"+ nuevoTurno.getPaciente().getNombreUsuario()
                +"', '"+ fechaYHoraConvertida +"', "+ nuevoTurno.getConsultorio()+", "+ nuevoTurno.getPrecio()+");";
        
        Connection conexion = DBManager.connect(); // Se abre una conexion con la BD
        
        Statement operacion; 
        
        try {
            operacion = conexion.createStatement();
            
            operacion.execute(operacionSQL1); // Ejecuta la operacion, crea usuario
            
            conexion.commit(); // Aplica los cambios an la BD
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            if(ex.getErrorCode() == 23505){
                throw new DAOException("EL TURNO NO ESTA DISPONIBLE!");
            }
            throw new DAOException(ex.getMessage());
        } finally {
            try {
                conexion.close(); // Se CIERRA la conexion para liberar el acceso
            } catch (SQLException ex) {
                throw new DAOException(ex.getMessage());
            }
        }
    }

    @Override
    public void registrarUsuario(Usuario nuevoUsuario, Object[] seleccionTipoUsuario) throws DAOException{
        // Operacion atomica, se crea el usuario y se asignan las funciones
        // Los usuarios son 'Usuarios genericos' del modelo en esta instancia
        List<String> operacionesSQL = new ArrayList();
        Object[] operacionesSQLArray;
        
        String operacionSQLAux1 = "SELECT ID FROM FUNCION WHERE NOMBRE = 'ADMINISTRADOR'";
        String operacionSQLAux2 = "SELECT ID FROM FUNCION WHERE NOMBRE = 'MEDICO'";
        String operacionSQLAux3 = "SELECT ID FROM FUNCION WHERE NOMBRE = 'PACIENTE'";
        
        String operacionSQL1 = "INSERT INTO USUARIO (NOMBRE_USUARIO, CLAVE_USUARIO, NOMBRE, APELLIDO, DNI) "
                + "VALUES ('"+ nuevoUsuario.getNombreUsuario() +"','"+ nuevoUsuario.getClaveUsuario() +"','"+ nuevoUsuario.getNombre() +"','"+ nuevoUsuario.getApellido() +"','"+ nuevoUsuario.getDni() +"')";
        
        for(int i=0; i < seleccionTipoUsuario.length; i++){
            // Agrega a la lista las operaciones dependiendo de cuantas funciones tiene el usuario
            if(seleccionTipoUsuario[i] == Administrador.class){
                operacionesSQL.add("INSERT INTO USUARIO_POR_FUNCION (NOMBRE_USUARIO, ID_FUNCION) VALUES ('"+ nuevoUsuario.getNombreUsuario() +"',("+ operacionSQLAux1 +"))");
            }
            if(seleccionTipoUsuario[i] == Medico.class){
                operacionesSQL.add("INSERT INTO USUARIO_POR_FUNCION (NOMBRE_USUARIO, ID_FUNCION) VALUES ('"+ nuevoUsuario.getNombreUsuario() +"',("+ operacionSQLAux2 +"))");
                operacionesSQL.add("INSERT INTO PRECIOS_POR_MEDICO (USUARIO_MEDICO, PRECIO_CONSULTA) VALUES ('"+ nuevoUsuario.getNombreUsuario()+"',"+ Medico.precioConsultaDefault +")");
            }
            if(seleccionTipoUsuario[i] == Paciente.class){
                operacionesSQL.add("INSERT INTO USUARIO_POR_FUNCION (NOMBRE_USUARIO, ID_FUNCION) VALUES ('"+ nuevoUsuario.getNombreUsuario() +"',("+ operacionSQLAux3 +"))");
            }
        }
        
        operacionesSQLArray = operacionesSQL.toArray();
        
        Connection conexion = DBManager.connect(); // Se abre una conexion con la BD
        
        try {
            Statement operacion = conexion.createStatement(); 
            
            operacion.execute(operacionSQL1); // Ejecuta la operacion, crea usuario
            
            for(int i=0; i < operacionesSQLArray.length; i++){
                // Ejecuta las operaciones, asocia funciones al usuario
                operacion.execute((String)operacionesSQLArray[i]);
            } 
            
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
    public int eliminarUsuario(String nUsuario) throws DAOException{
        String operacionSQL1 = "DELETE FROM USUARIO_POR_FUNCION WHERE NOMBRE_USUARIO = '"+ nUsuario +"';";
        String operacionSQL2 = "DELETE FROM USUARIO WHERE NOMBRE_USUARIO = '"+ nUsuario +"';";
        Connection conexion = DBManager.connect(); // Se abre una conexion con la BD
        int registrosAfectados = 0;
        
        try {
            Statement operacion = conexion.createStatement(); 
            operacion.execute(operacionSQL1); // Ejecuta la operacion, elimina en tabla
            registrosAfectados = operacion.executeUpdate(operacionSQL2); // Ejecuta la operacion, elimina en tabla
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
        return registrosAfectados;
    }
    
    // Reportes
    @Override
    public List<Usuario> listarUsuariosConFuncion(String nombreUsuarioBuscado) throws DAOException {
        String operacionSQL1 = "SELECT DISTINCT u.NOMBRE, APELLIDO, DNI, u.NOMBRE_USUARIO, CLAVE_USUARIO, f.NOMBRE AS NOMBRE_FUNCION \n" +
            "FROM USUARIO u \n" +
            "NATURAL JOIN USUARIO_POR_FUNCION uf JOIN FUNCION f \n" +
            "WHERE ID_FUNCION = ID AND u.NOMBRE_USUARIO = '" +nombreUsuarioBuscado+ "'";
        Connection conexion = DBManager.connect(); // Se abre una conexion con la BD
        ResultSet rs = null;
        List<Usuario> resultado = new ArrayList();
        
        try{
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
                            usuario = new Paciente( dni, nombre, apellido, nombreUsuario, claveUsuario);
                            break;
                    }
                    resultado.add(usuario);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new DAOException("ERROR DESCONOCIDO");
            }
        }catch(DAOException ex2){
           throw new DAOException(ex2.getMessage()) ;
           
        }finally{
            try {
                conexion.close(); // Se CIERRA la conexion para liberar el acceso
            } catch (SQLException e) {
		e.printStackTrace();
            }
        }
        
        
        return resultado; // Puede retornar mas de una fila ya que un usuario puede tener multiples roles
    }
    
    @Override
    public List<Usuario> listarUsuariosConFuncion() throws DAOException {
        String operacionSQL1 = "SELECT DISTINCT u.NOMBRE, APELLIDO, DNI, u.NOMBRE_USUARIO, CLAVE_USUARIO, f.NOMBRE AS NOMBRE_FUNCION \n" +
            "FROM USUARIO u \n" +
            "NATURAL JOIN USUARIO_POR_FUNCION uf JOIN FUNCION f \n" +
            "WHERE ID_FUNCION = ID\n" +
            "ORDER BY NOMBRE_USUARIO ASC";
        Connection conexion = DBManager.connect(); // Se abre una conexion con la BD
        ResultSet rs = null;
        List<Usuario> resultado = new ArrayList();
        
        try{
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
                            usuario = new Paciente( dni, nombre, apellido, nombreUsuario, claveUsuario);
                            break;
                    }
                    resultado.add(usuario);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new DAOException("ERROR DESCONOCIDO");
            }
        }catch(DAOException ex2){
           throw new DAOException(ex2.getMessage()) ;
           
        }finally{
            try {
                conexion.close(); // Se CIERRA la conexion para liberar el acceso
            } catch (SQLException e) {
		e.printStackTrace();
            }
        }
        
        
        return resultado;
    }
    
    @Override
    public List<Turno> listarTurnos() throws ServicioException {
        
        return null;
    }

    // Modificacion
    
    @Override
    public void asignarFuncionAdministrador(Usuario usuario) throws DAOException {
        
    }
    
    // Auxiliar
  
}
