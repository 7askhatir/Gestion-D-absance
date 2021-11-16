/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface Dao<T> {
    //read
    T getById(int id);
    List<T> getAll();
    
    //Create 
    boolean save(T item);
    boolean saveAll(List<T> items);
    
    //update
    boolean update(T item);
    
    //delet
    
    boolean delet(int id);
    
}
