/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Database.*;
import Data.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ahmed
 */
public class Login extends HttpServlet {

    ConnectDB conn = new ConnectDB();
    User usr = new User();
    HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            PrintWriter out = resp.getWriter();
            usr.username = req.getParameter("username");
            usr.pass = req.getParameter("pass");
            
            if (conn.checkLogin(usr)) {
                if (conn.isadmin(usr)) {
                  
                    resp.sendRedirect("indexusers.jsp");
                    
                } else {
                    out.print("user");
                   
                    resp.sendRedirect("index.html");
                }

            } else {
                
                out.print("username doesnot match");
            }
            } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
