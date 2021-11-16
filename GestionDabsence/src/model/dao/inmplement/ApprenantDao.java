/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.inmplement;

import domain.Apprenant;
import domain.Retar;
import domain.Staf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.Dao;
import model.dao.inmplement.database.Connect;

/**
 *
 * @author Admin
 */
public class ApprenantDao extends Connect implements Dao<Apprenant> {

    @Override
    public Apprenant getById(int id) {
         Apprenant u= new Apprenant();
        
        try{
            String sql ="SELECT * FROM `staf` where `iduser` =?";
            Connection con =ApprenantDao.getCon();
            PreparedStatement preparedstatement =(PreparedStatement) con.prepareStatement(sql);
            preparedstatement.setInt(1,id);
            ResultSet result= preparedstatement.executeQuery();
            
            
            while(result.next()){
                
                u.setIduser(result.getInt(1));
                u.setNomuser(result.getString(2));
                u.setEmailuser(result.getString(3));
                u.setPassuser(result.getString(4));
                
                
            }
            con.close();
            
        }
        catch(SQLException e){
            
        }
        return u;
    }

    public List<Apprenant> getAll(int id) {
         List<Apprenant> list= new ArrayList<Apprenant>();
        
        try{
            String sql ="SELECT * FROM `apprenant` where `promotion` = ?";
            Connection con =Connect.getCon();
            PreparedStatement preparedstatement =(PreparedStatement) con.prepareStatement(sql);
            preparedstatement.setInt(1,id);
            ResultSet result= preparedstatement.executeQuery();
            
            while(result.next()){
                
                Apprenant u= new Apprenant();
                u.setIduser(result.getInt(1));
                u.setEmailuser(result.getString(3));
                u.setNomuser(result.getString(2));
                u.setPassuser(result.getString(4));
                u.setPromotion(result.getInt(5));
                list.add(u);    
            }
            con.close();
            
        }
        catch(SQLException e){
            
        }
        return list;
    }

    @Override
    public boolean save(Apprenant item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveAll(List<Apprenant> items) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Apprenant item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delet(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Apprenant> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
