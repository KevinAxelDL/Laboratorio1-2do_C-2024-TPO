package Turnera_medica.Utiles;


import Turnera_medica.BD.DBManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {

	public void createUserTable() {

		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE usuarios ( id INTEGER IDENTITY, user VARCHAR(256) UNIQUE, email VARCHAR(256), pass VARCHAR(10))";

		try {
			Statement s = c.createStatement(); // Por cada operacion se abre una conexion con la BD
			s.execute(sql); // Ejecuta la operacion SQL
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close(); // Se CIERRA la conexion para liberar el acceso
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}
	
	public void dropUserTable() {

		Connection c = DBManager.connect();
		
		String sql = "DROP TABLE usuarios";
		
		try {
			Statement s = c.createStatement(); // Asigna 
			s.execute(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
