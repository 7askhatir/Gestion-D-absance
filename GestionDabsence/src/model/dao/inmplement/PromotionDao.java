/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.inmplement;

import com.mysql.jdbc.PreparedStatement;
import domain.Promotion;
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
public class PromotionDao extends Connect implements Dao<Promotion> {

    @Override
    public Promotion getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Promotion> getAll() {
        List<Promotion> list= new ArrayList<Promotion>();
        
        try{
            String sql ="SELECT * FROM `promotion`";
            Connection con =Connect.getCon();
            PreparedStatement preparedstatement =(PreparedStatement) con.prepareStatement(sql);
            ResultSet result= preparedstatement.executeQuery();
            
            while(result.next()){
                
                Promotion u= new Promotion();
                u.setIdpromotion(result.getInt(1));
                u.setNompromotion(result.getString(2));
                u.setAnnéepromotion(result.getString(3));
                u.setFormateur(result.getInt(4));

                list.add(u);
                
                
                
            }
            con.close();
            
        }
        catch(SQLException e){
            
        }
        return list;
    }

    @Override
    public boolean save(Promotion item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveAll(List<Promotion> items) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Promotion item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delet(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
