/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.inmplement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Connect {
     static Connection con;
     public static Connection getCon() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost/absent";
            String user ="root";
            String pass="";
            con=DriverManager.getConnection(url,user,pass);
            
}
        catch(ClassNotFoundException | SQLException e){
             e.printStackTrace();
        }
        return con;
    
    
} 
}
