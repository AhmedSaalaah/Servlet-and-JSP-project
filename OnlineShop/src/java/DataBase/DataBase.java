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
public class DataBase {

    private final String url = "jdbc:postgresql://localhost/products";
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

                users.add(new String[]{rs.getString("url"), rs.getString("name"), rs.getString("price")});

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
            SQLcommand = "Select * from products where cid=1";
            s = connection.createStatement();
            rs = s.executeQuery(SQLcommand);
            while (rs.next()) {

                mobiles.add(new String[]{rs.getString("url"), rs.getString("name"), rs.getString("price")});

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
            SQLcommand = "Select * from products where cid=2";
            s = connection.createStatement();
            rs = s.executeQuery(SQLcommand);
            while (rs.next()) {

                laptops.add(new String[]{rs.getString("url"), rs.getString("name"), rs.getString("price")});

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
     
     
    public int insert_product(String desc, int cid, String name, int quantity, int price, String url) {

        try {
            connect();
            SQLcommand = "insert into products (description,cid,name,quantity,price,url) values (?,?,?,?,?,?)";
            ps = connection.prepareStatement(SQLcommand);
            ps.setString(1, desc);
            ps.setInt(2, cid);
            ps.setString(3, name);
            ps.setInt(4, quantity);
            ps.setInt(5, price);
            ps.setString(6, url);
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
        dd.insert_product("	Dimensions	157 x 75.1 x 7.8 mm (6.18 x 2.96 x 0.31 in)\n" +
"Weight	172 g (6.07 oz)\n" +
"Build	Glass front, glass back, aluminum frame\n" +
"SIM	Dual SIM (Nano-SIM, dual stand-by)", 1, "Huawei-nova-4", 10 , 2500, "Images/huawei-nova-4-.jpg");
    }

}
