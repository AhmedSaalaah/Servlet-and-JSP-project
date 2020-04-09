package login;

import database.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class login extends HttpServlet {

    Connection conn1;
    Statement st ;
    ResultSet result ;
    String sqlCommand;
    int x = 0;
 ConnectDB db = new ConnectDB();
    @Override
    public void init() throws ServletException {
            
        try {
            Class.forName("org.postgresql.Driver");
            
            
            
            
            try {
                conn1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/onlineshop", "postgres", "1234");
            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        String uname = request.getParameter("username");
        String pass = request.getParameter("password");
              HttpSession httpSession1 = request.getSession(false);
        if (httpSession1 !=null && httpSession1.getAttribute("IsLogin").equals("true") && httpSession1.getAttribute("username").equals(uname) && httpSession1.getAttribute("password").equals(pass) && httpSession1.getAttribute("fname").equals(fname) && httpSession1.getAttribute("lname").equals(lname)) {
            response.sendError(5000, "you are already logged");
        } else {

            try {
                sqlCommand = "select username,password from users";
                st = conn1.createStatement();
                result = st.executeQuery(sqlCommand);
                PrintWriter out = response.getWriter();

                while (result.next()) {
                    if (result.getString(1).equals(uname) && result.getString(2).equals(pass)) {
                        x = 1;
                        HttpSession httpSession = request.getSession(true);
                        httpSession.setAttribute("IsLogin", "true");
                        httpSession.setAttribute("username", uname);
                        httpSession.setAttribute("fname", fname);
                        httpSession.setAttribute("lname", lname);
                        httpSession.setAttribute("password", pass);
                        httpSession.setAttribute("user_id", 3);
                        response.sendRedirect("product.html");

                    }

                }
                if (x == 0) {

                    response.sendRedirect("login.html");
                }

            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
    }
}
