/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Data.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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

    public Boolean checkLogin(User usr) throws SQLException, ClassNotFoundException {
        connect();
        String sql = "select * from users where username = ? and password = ?";
        pst = con.prepareStatement(sql);
        pst.setString(1, usr.username);
        pst.setString(2, usr.pass);
        rs = pst.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    public Boolean isadmin(User usr) throws SQLException, ClassNotFoundException {
        connect();
        String sql = "select * from users where username = ? and is_admin = true";
        pst = con.prepareStatement(sql);
        pst.setString(1, usr.username);
        rs = pst.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    public int registerUser(User usr) throws ClassNotFoundException, SQLException {
        connect();
        String sql = "insert into users (username,password,email,credit_limit) values (?,?,?,?)";
        pst = con.prepareStatement(sql);
        System.out.println("inserted");
        pst.setString(1, usr.username);
        pst.setString(2, usr.pass);
        pst.setString(3, usr.email);
        pst.setInt(4, usr.credit_limit);
        int rs = pst.executeUpdate();
        System.out.println(rs);

        return rs;
    }

    public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
        connect();
        String sql = "select * from users where is_admin is null";
        List<User> users = new ArrayList<User>();
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            users.add(new User(rs.getInt("user_id"), 
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getInt("credit_limit")));
        }

        return users;

    }

    public void deleteUser(int userId) {
        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("delete from users where user_id=?");
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectDB c = new ConnectDB();
        c.connect();
        User u = new User();
        u.username = "admin";
        u.pass = "admin";
        u.email = "admin";
        u.credit_limit = 1000;
        List<User> list =c.getAllUsers();
        for(User q : list){
            System.out.println(q.username);
        }
// 
    }

}
