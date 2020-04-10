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
import javax.servlet.http.HttpSession;

/**
 *
 * @author ahmed
 */
public class Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
        
        HttpSession session = req.getSession();
        session.removeAttribute("userlogin");
        session.invalidate();
=======

        HttpSession session = req.getSession(false);
        session.setAttribute("admin", "");
        session.setAttribute("user", null);
        session.setAttribute("islogin", null);
        resp.sendRedirect("Login.jsp");
>>>>>>> 10820709941cda5c33b240eb10181f887c74b4cc
    }

    
    
}