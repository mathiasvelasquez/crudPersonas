/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fabrica;
import DAO.PersonaDAO;
import Interfas.PersonaIDAO;
/**
 *
 * @author Usuario
 */
public class DAOFabrica {
 
    public enum DaoType{
        PERSONA
    }
    /**
     * @param daoType recibe el tipo de dao que quieres crear. PERSONA|     
     * @return una instancia del dao que indicamos
    */
    public static PersonaIDAO getDAO (DaoType daoType){
        PersonaIDAO dao = null;
        switch (daoType){
            case PERSONA:
                dao = new PersonaDAO();
                break;
        }
        return dao;
    }
   
}
