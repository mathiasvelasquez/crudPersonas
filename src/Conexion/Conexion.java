/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Conexion {

    String user_    = "postgres";
    String pass_    = "123";
    
    //Instancia de la clase
    private static Conexion connectInstance;
    //Variable para realizar la conexión
    private Connection connection;
    //Dirección y nombre de la bd conectarnos
    private final String URL = "jdbc:postgresql://localhost:9090/crudPersonas";
    //Nombre de usuario autorizado para conectarse
    private final String USER = user_;
    //Contraseña para conectarnos
    private final String PASSWORD = pass_;
    
    private Conexion() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            System.out.println("OK ");
        }
    }
//Implementación del patrón singleton para acceder a una instancia única de la clase
    public static Conexion getInstance(){
        if (connectInstance == null ){
            connectInstance = new Conexion();
        }
        return connectInstance;
    }
       
    public Connection getConnection(){
        return connection;
    }
}
