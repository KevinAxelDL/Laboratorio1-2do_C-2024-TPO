/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.Servicios;

import Turnera_medica.DAO.AdministradorDAOH2;
import Turnera_medica.Modelo.Administrador;

/**
 *
 * @author KevinDL
 */
public abstract class AdministradorServicios {
    public static void registrarAdministrador(Administrador nuevoAdmin){
        AdministradorDAOH2 adminDAO = new AdministradorDAOH2();
        adminDAO.registrarAdministrador(nuevoAdmin);
    }
}
