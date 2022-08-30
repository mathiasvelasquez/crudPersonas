/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crudpersonas;

import Conexion.Conexion;
import Fabrica.DAOFabrica;
import Interfas.PersonaIDAO;
import Modelo.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Usuario
 */
public class CrudPersonas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

       Persona persona= new Persona();

        //Obtenemos instancia del dao Persona
        PersonaIDAO dao = DAOFabrica.getDAO(DAOFabrica.DaoType.PERSONA);

        //Lista para almacenar registros
        List<Persona> personas = new ArrayList();

        Scanner sc = new Scanner(System.in);
        //Para almacenar la acción que queremos realizar
        int option;
        //Guarda el id del PERSONA que queramos
        int idPlayer;
        //Variable para controlar el flujo del menú
        boolean redo = true;

        do {
            System.out.println("*# GESTIÓN DE PERSONA #*");
            System.out.println("¿Qué acción quieres realizar?");
            System.out.println("[1] Crear registro\n"
                    + "[2] Actualizar registro\n"
                    + "[3] Eliminar registro\n"
                    + "[4] Buscar un registro\n"
                    + "[5] Mostrar todos los registros\n"
                    + "[0] Salir");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("|REGISTRAR PERSONA|");
                    System.out.println("Ingresa el nombre: ");
                    persona.setNombre(sc.next());
                    System.out.println("Ingresa el apellido: ");
                    persona.setApellido(sc.next());
                    System.out.println("Ingresa el estatura: ");
                    persona.setEstatura(sc.nextDouble());
                    System.out.println("Inserta peso: ");
                    persona.setPeso(sc.nextDouble());
                    System.out.println("Inserta edad: ");
                    persona.setEdad(sc.nextInt());
                    System.out.println(dao.createRecord(persona));
                    break;
                case 2:
                    System.out.println("|ACTUALIZAR Persona|");
                    System.out.println("Id del Persona: ");
                    idPlayer = sc.nextInt();
                    System.out.println("Ingresa el nombre: ");
                    persona.setNombre(sc.next());
                    System.out.println("Ingresa el apellido: ");
                    persona.setApellido(sc.next());
                    System.out.println("Ingresa el estatura: ");
                    persona.setEstatura(sc.nextDouble());
                    System.out.println("Inserta peso: ");
                    persona.setPeso(sc.nextDouble());
                    System.out.println("Inserta edad: ");
                    persona.setEdad(sc.nextInt());
                    System.out.println(dao.updateRecord(persona, idPlayer));
                    break;
                case 3:
                    System.out.println("|ELIMINAR PERSONA|");
                    System.out.println("Id de la persona: ");
                    idPlayer = sc.nextInt();
                    System.out.println(dao.deleteRecord(idPlayer));
                    break;
                case 4:
                    System.out.println("|BUSCAR BALON|");
                    System.out.println("Id de la persona: ");
                    idPlayer = sc.nextInt();
                    Persona b = (Persona) dao.readRecord(idPlayer);
                    if (b==null) {
                       System.out.println("Persona no encontrada"); 
                    }else{
                       System.out.println("Persona encontrada");
                        System.out.println("-> " + b);
                    }
                    break;
                case 5:
                    System.out.println("|LISTA DE REGISTROS|");
                    personas.clear();
                    personas = dao.readRecords();
                    for (Persona record : personas) {
                        System.out.println(record.toString());
                    }
                    break;  
                case 0:
                    System.out.println("|SALIENDO...|");
                    break;
                default:
                    System.out.println("Opción no válida!");
            }
            
            if (option == 0) {
                redo = false;
            }else{
                System.out.println("¿Realizar otra acción? [1] Sí/[2] No");
                option = sc.nextInt();
                if(option != 1){
                    redo = false;
                    System.out.println("|SALIENDO...|");
                }
            }

        } while (redo);

    }
        
    }
    

