/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.DAO.Utiles;

import Turnera_medica.Excepciones.DAOException;
import Turnera_medica.Modelo.Administrador;
import Turnera_medica.Modelo.Medico;
import Turnera_medica.Modelo.Paciente;
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
    
    public static int convertirClaseAID(Class<?> clase) throws DAOException{
        //Retorna el ID asignado en la base de datos en base a un tipo de clase
        if(clase == Administrador.class){
            return 10;
        }
        
        if(clase == Medico.class){
            return 11;
        }
        
        if(clase == Paciente.class){
            return 12;
        }
        return 0;
    }
}
