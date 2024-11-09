/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.DAO;

import Turnera_medica.DAO.Interfaces.AdministradorDAO;
import Turnera_medica.Modelo.Administrador;

/**
 *
 * @author KevinDL
 */

public class AdministradorDAOH2 implements AdministradorDAO{

    @Override
    public void registrarAdministrador(Administrador nuevoAdmin) {
        String consultaSQLAux1 = "SELECT ID FROM FUNCION WHERE NOMBRE = 'ADMINISTRADOR'";
        String consultaSQL1 = "INSERT INTO USUARIO (NOMBRE_USUARIO, CLAVE_USUARIO) VALUES ("+ nuevoAdmin.getNombreUsuario() +","+ nuevoAdmin.getClaveUsuario() +")";
        String consultaSQL2 = "INSERT INTO USUARIO_POR_FUNCION (NOMBRE_USUARIO, ID_FUNCION) VALUES ("+ nuevoAdmin.getNombreUsuario() +", ("+ consultaSQLAux1 +") )";
    }

    @Override
    public void eliminarAdministrador(String nUsuario, String uClave) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
