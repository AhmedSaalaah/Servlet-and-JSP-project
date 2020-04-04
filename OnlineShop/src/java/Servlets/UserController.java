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
import Data.User;
import Database.ConnectDB;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ahmed
 */
public class UserController extends HttpServlet {

    private static String LIST_USER = "/getuserData.jsp";
    ConnectDB con;
    User user;

    public UserController() throws ClassNotFoundException {
        super();
        con = new ConnectDB();
        con.connect();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession(false);
            String admin =(String) session.getAttribute("admin");
            if(admin.equals("yes")){
            String forward = "";
            req.setAttribute("users", con.getAllUsers());
            String action = req.getParameter("action");

            if (action.equalsIgnoreCase("delete")) {
                int userId = Integer.parseInt(req.getParameter("userId"));
                con.deleteUser(userId);
                forward = LIST_USER;
                req.setAttribute("users", con.getAllUsers());

            } else if (action.equalsIgnoreCase("listUsers")) {

                req.setAttribute("users", con.getAllUsers());
                forward = LIST_USER;
            }

            RequestDispatcher e = req.getRequestDispatcher(forward);
            e.forward(req, resp);
            }else{
            
                 resp.sendRedirect("Login.html");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
