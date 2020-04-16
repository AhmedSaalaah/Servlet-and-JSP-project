/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author ramr
 */
public class Database2 {

    private final String url =  "jdbc:postgresql://localhost:5432/onlineshop";
    private final String user = "postgres";
    private final String password = "1234";
    public Connection connection = null;
    public String SQLcommand = null;
    public ResultSet rs = null;
    public PreparedStatement ps = null;
    public Statement s = null;

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection made successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void disconnect() throws SQLException {
        connection.close();
        ps.close();
        System.out.println("Connection disabled");
    }

    boolean r = false;
    int inserted = 0;

    public Vector<String[]> view_products() {
        Vector<String[]> users = new Vector();
        try {
            connect();
            SQLcommand = "Select * from products";
            s = connection.createStatement();
            rs = s.executeQuery(SQLcommand);
            while (rs.next()) {

                users.add(new String[]{rs.getString("image"), rs.getString("product_name"), rs.getString("price")});

            }
            r = true;
        } 
        catch (Exception e) {
            e.printStackTrace();
            disconnect();
            r = false;
        }
        finally {

            return users;
        }
    }
    
     public Vector<String[]> view_Mobiles() {
        Vector<String[]> mobiles = new Vector();
        try {
            connect();
            SQLcommand = "Select * from products where category='mobiles'";
            s = connection.createStatement();
            rs = s.executeQuery(SQLcommand);
            while (rs.next()) {

                mobiles.add(new String[]{rs.getString("image"), rs.getString("product_name"), rs.getString("price")});

            }
            r = true;
        } 
        catch (Exception e) {
            e.printStackTrace();
            disconnect();
       
        }
        finally {

            return mobiles;
        }
    }

     public Vector<String[]> view_Laptops() {
        Vector<String[]> laptops = new Vector();
        try {
            connect();
            SQLcommand = "Select * from products where category='laptops'";
            s = connection.createStatement();
            rs = s.executeQuery(SQLcommand);
            while (rs.next()) {

                laptops.add(new String[]{rs.getString("image"), rs.getString("product_name"), rs.getString("price")});

            }
            r = true;
        } 
        catch (Exception e) {
            e.printStackTrace();
            disconnect();
       
        }
        finally {

            return laptops;
        }
    }
     
     
    public int insert_product(String name, int price, String category,String image,String desc,int quantity) {

        try {
            connect();
            SQLcommand = "insert into products (product_name,price,category,image,description,quantity) values (?,?,?,?,?,?)";
            ps = connection.prepareStatement(SQLcommand);
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setString(3,category);
            ps.setString(4, image);
            ps.setString(5,desc);
            ps.setInt(6,quantity);
            inserted=ps.executeUpdate();
            
        } 
        
        catch (SQLException ex) {
            
            ex.printStackTrace();
            inserted = 0;
        } 
        
        finally {
            
            return inserted;
        }

    }

    public static void main(String[] args) {
        DataBase dd = new DataBase();
//        dd.view_products();

         Insert i=new Insert();
         
    }

}
