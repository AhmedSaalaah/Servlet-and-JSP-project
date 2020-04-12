/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DataBase.ConnectDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Data.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ahmed
 */
public class Login extends HttpServlet {

    ConnectDB conn = new ConnectDB();
    User usr = new User();
    HttpSession session;


    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        getServletContext();
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            PrintWriter out = resp.getWriter();
            usr.username = req.getParameter("username");
            usr.pass = req.getParameter("pass");
            int id = conn.getUserId(usr);

            if (conn.checkLogin(usr)) {
                if (conn.isadmin(usr)) {
                    HttpSession session = req.getSession(true);
                    session.setAttribute("admin", "yes");
                    session.setAttribute("username", usr.username);
                    
                    session.setAttribute("islogin", "yes");
                    resp.sendRedirect("indexProducts.jsp");

                } else {
                    out.print("user");
                    HttpSession session = req.getSession(true);
                    session.setAttribute("user", "yes");
                    session.setAttribute("islogin", "yes");
                    session.setAttribute("user_id",id );
                    session.setAttribute("username", usr.username);
                    resp.sendRedirect("Home.jsp");
                }

            } else {

                out.print("username doesnot match");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws ServletException {
       
    }

}
