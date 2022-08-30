/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Interfas.PersonaIDAO;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class PersonaDAO implements PersonaIDAO<Persona, Integer>  {

    //Declaración de variable para preparar las consultas
    private Connection connection;
    //Declaración de variable para insertar valores a consultas
    private PreparedStatement preQuery;
    //Devuelve true si se ejecutó correctamente y false si algo falló
    private boolean isSuccesfully = false;
    //Objeto que servirá para almacenar información al buscar un registro
    private Persona persona;
    //Lista de registros
    private List<Persona> personas;

 
    
        //Arreglo con las consultas que se usarán para la tabla Personas
    private final String[] QUERIES = {
        "INSERT INTO modelo.persona(nombre, apellido, estatura, peso, edad) VALUES (?,?,?,?,?)",
        "SELECT * FROM modelo.persona WHERE id = ?;",
        "UPDATE modelo.persona SET nombre = ? , apellido= ?, estatura= ?, peso=? , edad= ? WHERE (id = ?);",
        "DELETE FROM modelo.persona WHERE (id = ?);",
        "SELECT * FROM modelo.persona;"
    };
    //Constructor de la clase en donde se inicializarán las variables previamente declaradas
    public PersonaDAO() {
        connection = Conexion.getInstance().getConnection();
        persona= new Persona();
        personas= new ArrayList();
        
        
    }  
    @Override
    public boolean createRecord(Persona model){
        try {
            preQuery = connection.prepareStatement(QUERIES[0]);
            
            preQuery.setString(1, model.getNombre());
            preQuery.setString(2, model.getApellido());
            preQuery.setDouble(3, model.getEstatura());
            preQuery.setDouble(4, model.getPeso());
            preQuery.setDouble(5, model.getEdad());
            
            
            //Mostrar la consulta completa en pantalla
            System.out.println(preQuery);

            if (preQuery.executeUpdate() > 0) {
                isSuccesfully = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSuccesfully;
    }

 @Override
    public Persona readRecord(Integer idModel) {
        try {
            preQuery = connection.prepareStatement(QUERIES[1]);
            preQuery.setInt(1, idModel);
            ResultSet data = preQuery.executeQuery();
            
           if(data.next()==false){ 
             System.out.println("No se encontro Balon");
             persona = null;
           }else{
                persona.setId(data.getInt("id"));
                persona.setNombre(data.getString("nombre"));
                persona.setApellido(data.getString("apellido"));
                persona.setEstatura(data.getDouble("estatura"));
                persona.setPeso(data.getDouble("peso"));
                persona.setEdad(data.getInt("edad")); 
           }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al buscar balon");
        }

        return persona;
    }

    @Override
    public boolean updateRecord(Persona model, Integer idModel) {
        try {
            preQuery = connection.prepareStatement(QUERIES[2]);

            preQuery.setString(1, model.getNombre());
            preQuery.setString(2, model.getApellido());
            preQuery.setDouble(3, model.getEstatura());
            preQuery.setDouble(4, model.getPeso());
            preQuery.setDouble(5, model.getEdad());
            preQuery.setInt(6, idModel);

            if (preQuery.executeUpdate() > 0) {
                isSuccesfully = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSuccesfully;
    }

    @Override
    public boolean deleteRecord(Integer idModel) {
        try {
            preQuery = connection.prepareStatement(QUERIES[3]);
            preQuery.setInt(1, idModel);

            if (preQuery.executeUpdate() > 0) {
                isSuccesfully = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSuccesfully;
    }

    @Override
    public List<Persona> readRecords() {
        try {
            preQuery = connection.prepareStatement(QUERIES[4]);
            ResultSet data = preQuery.executeQuery();

            while (data.next()) {
                personas.add(new Persona(
                        data.getInt("id"), 
                        data.getString("nombre"), 
                        data.getString("apellido"), 
                        data.getDouble("estatura"),
                        data.getDouble("peso"),
                        data.getInt("edad")
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personas;
    }
}
