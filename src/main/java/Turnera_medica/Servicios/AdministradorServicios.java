/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica.Servicios;

import Turnera_medica.DAO.AdministradorDAOH2;
import Turnera_medica.Excepciones.DAOException;
import Turnera_medica.Excepciones.ServicioException;
import Turnera_medica.Modelo.Medico;
import Turnera_medica.Modelo.Paciente;
import Turnera_medica.Modelo.Turno;
import Turnera_medica.Modelo.Usuario;
import Turnera_medica.UI.DatosReportes.GananciasReporte;
import java.util.List;


/**
 *
 * @author KevinDL
 */
public class AdministradorServicios extends UsuarioServicios{
    
    // Metodos de clase
    public static void registrarUsuario(Usuario nuevoUsuario, List<Class<?>> opcionesUsuario) throws ServicioException{
        AdministradorDAOH2 adminDAOH2 = new AdministradorDAOH2();
        Object[] arrayOpcionesUsuario = opcionesUsuario.toArray();
        
        try {
            adminDAOH2.registrarUsuario(nuevoUsuario, arrayOpcionesUsuario); // Se crea el usuario en la BD
        } catch (DAOException ex) {
            throw new ServicioException(ex.getMessage());
        }
    }
    
    public static void registrarTurno(String medico, String paciente, String fechaYHora, String consultorio) throws ServicioException{
        // Antes de registrar un turno se debe verificar si se ingresaron los usuarios correctos
        AdministradorDAOH2 adminDAOH2 = new AdministradorDAOH2();
        //Medico nuevoMedico = null;
        //Paciente nuevoPaciente = null;
        try {
            Medico medicoRes = (Medico) adminDAOH2.obtenerUsuario(medico, Medico.class); // Retorna 1 usuario
            Paciente pacienteRes = (Paciente) adminDAOH2.obtenerUsuario(paciente, Paciente.class); // Retorna 1 usuario
            
            int consultorioComoNumero = AdministradorServicios.transformarNumeroDeConsultorio(consultorio);
            
            Turno nuevoTurno = new Turno(medicoRes, pacienteRes, fechaYHora, consultorioComoNumero);
            
            adminDAOH2.registrarTurno(nuevoTurno);
            
        } catch (DAOException ex) {
            throw new ServicioException(ex.getMessage());
        }
    }
    
    public static int eliminarUsuario(String nUsuario) throws ServicioException{
        AdministradorDAOH2 adminDAOH2 = new AdministradorDAOH2();
        int resultado;
        try {
            resultado = adminDAOH2.eliminarUsuario(nUsuario);
        } catch (DAOException ex) {
            throw new ServicioException(ex.getMessage());
        }
        return resultado;
    }
    
    public static List<Usuario> listarUsuariosConFuncion() throws ServicioException{
        AdministradorDAOH2 adminDAOH2 = new AdministradorDAOH2();
        List<Usuario> resultado;
        
        try {
            resultado = adminDAOH2.listarUsuariosConFuncion();
        } catch (DAOException ex) {
            throw new ServicioException(ex.getMessage());
        }
        
        return resultado;
    }
    
    public static List<Turno> listarTurnos() throws ServicioException{
        AdministradorDAOH2 adminDAOH2 = new AdministradorDAOH2();
        List<Turno> resultado;
        try {
            resultado = adminDAOH2.listarTurnos();
        } catch (DAOException ex) {
            throw new ServicioException(ex.getMessage());
        }
        return resultado;
    }
    
    public static List<Turno> listarTurnos(String nombreUsuario, Class<?> tipoUsuario) throws ServicioException{
        AdministradorDAOH2 adminDAOH2 = new AdministradorDAOH2();
        List<Turno> resultado;
        try {
            resultado = adminDAOH2.listarTurnos(nombreUsuario, tipoUsuario);
        } catch (DAOException ex) {
            throw new ServicioException(ex.getMessage());
        }
        return resultado;
    }
    
    public static List<GananciasReporte> listarGanancias(String fechaDesde, String fechaHasta, String usuarioMedico) throws ServicioException{
        AdministradorDAOH2 adminDAOH2 = new AdministradorDAOH2();
        List<GananciasReporte> resultado;
        
        if(usuarioMedico == null || usuarioMedico.isBlank() || usuarioMedico.isEmpty()){
            try {
                resultado = adminDAOH2.listarGanancias(fechaDesde, fechaHasta);
            } catch (DAOException ex) {
                throw new ServicioException(ex.getMessage());
            }
        }else{
            try {
                resultado = adminDAOH2.listarGanancias(fechaDesde, fechaHasta, usuarioMedico);
            } catch (DAOException ex) {
                throw new ServicioException(ex.getMessage());
            }
        }
        
        
        return resultado;
    }
    
    // Auxiliares
    private static int transformarNumeroDeConsultorio(String dato) throws ServicioException{
        int resultado;
        if(dato.isBlank() || dato.isEmpty()){
            throw new ServicioException("CONSULTORIO NO VALIDO!");
        }else{
            try {
                resultado = Integer.parseInt(dato); // Los caracteres deben ser numeros
            } catch (NumberFormatException e) {
                throw new ServicioException("CONSULTORIO NO VALIDO!");
            }
        } 
        return resultado;
    }
    
    
}
