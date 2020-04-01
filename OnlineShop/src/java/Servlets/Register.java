/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Database.*;
import Data.*;

/**
 *
 * @author ahmed
 */
public class Register extends HttpServlet {

    ConnectDB conn = new ConnectDB();
    User usr = new User();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            PrintWriter out = resp.getWriter();
           String username = usr.username = req.getParameter("username");
           String pass=  usr.pass = req.getParameter("pass");
            String email =usr.email = req.getParameter("email");
           int credit= usr.credit_limit = Integer.parseInt(req.getParameter("credit"));

            if (conn.registerUser(usr) ==1 &&username!=null) {

                resp.sendRedirect("Login.html");
            } else {
                out.print("Data Requried");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
