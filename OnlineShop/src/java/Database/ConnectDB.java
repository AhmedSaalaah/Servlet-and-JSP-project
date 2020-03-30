/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Data.User;
import java.sql.*;


/**
 *
 * @author ahmed
 */
public class ConnectDB {
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public Connection connect() throws ClassNotFoundException {

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/onlineshop", "postgres", "ahmed");
            System.out.println("connection success");
        } catch (SQLException ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        return con;

    }
    
    public Boolean checkLogin(User usr) throws SQLException{
        String sql = "select * from users where username = ? and password = ?";
        pst =con.prepareStatement(sql);
        pst.setString(1, usr.username);
        pst.setString(2, usr.pass);
        rs=pst.executeQuery();
        if(rs.next()){
                return true;
            }
         
        return false;
            
    }
    
    public Boolean isadmin(User usr) throws SQLException{
        String sql = "select * from users where isadmin = true";
        pst =con.prepareStatement(sql);
        pst.setBoolean(1, usr.isadmin);
        
        rs=pst.executeQuery();
        if(rs.next()){
                return true;
            }
         
        return false;
            
    }
    
    
    
    public static void main(String[] args) throws ClassNotFoundException {
        
    }
    
}
