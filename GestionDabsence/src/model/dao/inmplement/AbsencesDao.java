/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.inmplement;

import com.mysql.jdbc.PreparedStatement;
import domain.Absences;
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
public class AbsencesDao extends Connect implements Dao<Absences> {

    

    @Override
    public List<Absences> getAll() {
        List<Absences> list= new ArrayList<Absences>();
        
        try{
            String sql ="SELECT * FROM absences where typeabs =\"NULL\"";
            Connection con =Connect.getCon();
            PreparedStatement preparedstatement =(PreparedStatement) con.prepareStatement(sql);
            ResultSet result= preparedstatement.executeQuery();
            
            while(result.next()){
                
                Absences u= new Absences();
                u.setIdabsence(result.getInt(1));
                u.setIdapprenant(result.getInt(3));
                u.setIdformateur(result.getInt(2));
                u.setTypeabs(result.getString(4));
                u.setDateabs(result.getString(5));
               
                
                list.add(u);
                
                
                
            }
            con.close();
            
        }
        catch(SQLException e){
            
        }
        return list;
    }

    @Override
    public boolean save(Absences item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveAll(List<Absences> items) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean update(int id,String jus)  {
        boolean a;
        try{
         Connection con =Connect.getCon();
         String query ="UPDATE `absent`.`absences` SET `typeabs` = ? WHERE `absences`.`idabsence` = ?;"; 
         PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
         preparedStmt.setInt(2,id);
         preparedStmt.setString(1,jus);
         preparedStmt.executeUpdate();
         System.out.print(preparedStmt);
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
    public boolean update(Absences item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Absences getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Absences> getAll(String Table) {
         List<Absences> list= new ArrayList<Absences>();
        
        try{
            String sql ="SELECT * FROM `absences` where idapprenant in "+Table+" AND  `typeabs`=\"NULL\"";
            Connection con =Connect.getCon();
            java.sql.PreparedStatement preparedstatement =(java.sql.PreparedStatement) con.prepareStatement(sql);
            ResultSet result= preparedstatement.executeQuery();
            
            while(result.next()){
                
                Absences u= new Absences();
                u.setIdabsence(result.getInt(1));
                u.setIdapprenant(result.getInt(3));
                u.setIdformateur(result.getInt(2));
                u.setTypeabs(result.getString(4));
                u.setDateabs(result.getString(5));
               
                
                list.add(u);
                
                
                
            }
            con.close();
            
        }
        catch(SQLException e){
            
        }
        return list;
    }
    
}
