/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.inmplement;

import domain.Staf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.Dao;
import model.dao.inmplement.database.Connect;

/**
 *
 * @author Admin
 */
public class StafDao extends Connect implements Dao<Staf> {
    @Override
    public Staf getById(int id) {
         Staf u= new Staf();
        
        try{
            String sql ="SELECT * FROM `staf` where `iduser` =?";
            Connection con =StafDao.getCon();
            PreparedStatement preparedstatement =(PreparedStatement) con.prepareStatement(sql);
            preparedstatement.setInt(1,id);
            ResultSet result= preparedstatement.executeQuery();
            
            while(result.next()){
                
                u.setIduser(result.getInt(1));
                u.setNomuser(result.getString(2));
                u.setEmailuser(result.getString(3));
                u.setPassuser(result.getString(4));
                u.setTypeuser(result.getString(5));  
            }
            con.close();
            
        }
        catch(SQLException e){
            
        }
        return u;

        
    }

    @Override
    public List<Staf> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(Staf item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveAll(List<Staf> items) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Staf item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delet(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
