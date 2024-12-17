/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.DAO.Utiles;

import Turnera_medica.Excepciones.DAOException;
import java.sql.Timestamp;

/**
 *
 * @author KevinDL
 */
public abstract class HerramientasDAO {
    public static Timestamp convertirATimeStamp(String fechaYHora) throws DAOException{
        //Formato aceptado: yyyy-MM-dd HH:mm:ss; ejemplo: "2024-12-16 10:15:30"
        try {
            Timestamp timestamp = Timestamp.valueOf(fechaYHora);
            return timestamp;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new DAOException("FORMATO DE FECHA-HORA INCORRECTO!");
        }
    }
}
