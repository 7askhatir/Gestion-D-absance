/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.inmplement;

import com.mysql.jdbc.PreparedStatement;
import domain.Absences;
import domain.Retar;
import java.sql.Connection;
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
public class RetarDao extends Connect implements Dao<Retar>{

    @Override
    public Retar getById(int id) {
        return null;
       
    }

    @Override
    public List<Retar> getAll() {
        List<Retar> list= new ArrayList<Retar>();
        
        try{
            String sql ="SELECT * FROM `retar` where jusif=\"NULL\"";
            Connection con =Connect.getCon();
            PreparedStatement preparedstatement =(PreparedStatement) con.prepareStatement(sql);
            ResultSet result= preparedstatement.executeQuery();
            
            while(result.next()){
                
                Retar u= new Retar();
                u.setIdretar(result.getInt(1));
                u.setIdapprenant(result.getInt(4));
                u.setIdformateur(result.getInt(3));
                u.setDuréretar(result.getInt(2));
                u.setJusif(result.getString(5));

                list.add(u);
                
                
                
            }
            con.close();
            
        }
        catch(SQLException e){
            
        }
        return list;
    }

    @Override
    public boolean save(Retar item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveAll(List<Retar> items) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public boolean update(int id,String jus)  {
        boolean a;
        try{
         Connection con =Connect.getCon();
         String query ="UPDATE `absent`.`retar` SET `jusif` = ? WHERE `retar`.`idretar` = ?;"; 
         PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
         preparedStmt.setInt(2,id);
         preparedStmt.setString(1,jus);
         preparedStmt.executeUpdate();
         
         a= true;
         con.close();
     }catch(Exception e){
         System.err.print( e.getClass().getName() + ": " + e.getMessage());
         a= false;
     }
        return a;
    }

    @Override
    public boolean delet(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Retar item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    public List<Retar> getAll(String Table) {
        List<Retar> list= new ArrayList<Retar>();
        
        try{
            String sql ="SELECT * FROM `retar` where idapprenant in "+Table+" AND  jusif=\"NULL\"";
            Connection con =Connect.getCon();
            java.sql.PreparedStatement preparedstatement =(java.sql.PreparedStatement) con.prepareStatement(sql);
            ResultSet result= preparedstatement.executeQuery();
            
            while(result.next()){
                
                Retar u= new Retar();
                u.setIdretar(result.getInt(1));
                u.setIdapprenant(result.getInt(4));
                u.setIdformateur(result.getInt(3));
                u.setDuréretar(result.getInt(2));
                u.setJusif(result.getString(5));

                list.add(u);
                
                
                
            }
            con.close();
            
        }
        catch(SQLException e){
            
        }
        return list;
    }

    
    
}
