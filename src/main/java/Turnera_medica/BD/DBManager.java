package Turnera_medica.BD;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

	private static final String DB_DRIVER = "org.h2.Driver";// Direccion del driver a cargar
	private static final String DB_BASE_URL = "jdbc:h2:tcp://localhost//{DIR}";
	private static final String DB_NAME = "bd_principal";
	private static final String DB_USERNAME = "admin";
	private static final String DB_PASSWORD = "admin";

	public static Connection connect() {
		Connection c = null;
		try {
                    // Paso 1: Cargar el dirver a MP
			Class.forName(DB_DRIVER);// Carga en memoria la clase del driver
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		try {
                    // Paso 2: conectarse a la BD
			String url = "jdbc:h2:tcp://localhost//{DIR}/"+DB_NAME;
			url = url.replace("{DIR}", getDirectorioBase());
			System.out.println(url);
			c = DriverManager.getConnection(url, DB_USERNAME, DB_PASSWORD);
			c.setAutoCommit(false);// A pedido de la catedra debe estar en false
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		return c;
	}

	private static String getDirectorioBase() {
		File currDir = new File("BD/h2/base_de_datos/");
		return currDir.getAbsolutePath();
	}

	public static String obtenerUbicacionBase() {
		String url = "jdbc:h2:tcp://localhost//{DIR}/" + DB_NAME;
		url = url.replace("{DIR}", getDirectorioBase());
		return url;
	}

}
