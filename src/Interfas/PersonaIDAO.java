/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfas;

import java.util.List;

/**
 *
 * /**
 * @param <T> Clase que corresponde al modelo del dao
 * @param <V> Tipo de dato del id del modelo
 */
public interface PersonaIDAO<T, V> {
/**
     * @param model objeto que guardará
     * @return true si se creó el registro, false si falló
     */
    public boolean createRecord(T model);

    /**
     * @param idModel clave del registro a consultar
     * @return el registro encontrado
     */
    public T readRecord(V idModel);

    /**
     *
     * @param model objeto con nuevos valores a almacenar
     * @param idModel clave del registro a modificar
     * @return 
     */
    public boolean updateRecord(T model, V idMod);
    /**
     *
     * @param idModel clave del registro a eliminar
     * @return 
     */
    public boolean deleteRecord(V idModel);

    /**
     *
     * @return lista de todos los registros
     */
    public List<T> readRecords();
    
}
