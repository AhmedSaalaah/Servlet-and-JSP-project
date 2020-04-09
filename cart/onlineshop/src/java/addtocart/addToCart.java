package addtocart;

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

public class addToCart extends HttpServlet {

    PreparedStatement preparedStatment;
    Connection conn1;
    Statement st;
    ResultSet result;
    String sqlCommand;
    Integer ud;
    Integer pi;
    Integer oi;
    Integer price;
 ConnectDB db = new ConnectDB();
    @Override
    public void init() throws ServletException {
 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession1 = request.getSession(false);
        if (httpSession1 != null && httpSession1.getAttribute("IsLogin").equals("true")) {
            try {
                ud = (Integer) httpSession1.getAttribute("user_id");
                try {
                    result = db.verifyUserExist(ud);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(addToCart.class.getName()).log(Level.SEVERE, null, ex);
                }
                PrintWriter out = response.getWriter();
                if (!result.next() == false) {
                    int i = 0;
                    
                    try {
                        result = db.getUserId(ud);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(addToCart.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    while (result.next()) {
                        if (result.getString(2) != null) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                    }
                    if (i == 1) {

                        pi = Integer.parseInt(request.getParameter("product_id"));
                        try {
                            fun1(pi);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(addToCart.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        pi = Integer.parseInt(request.getParameter("product_id"));
                        try {
                            insertingIntoOrderProducts(pi);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(addToCart.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {

                    pi = Integer.parseInt(request.getParameter("product_id"));
                    try {
                        fun1(pi);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(addToCart.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(addToCart.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        } else {
            response.sendRedirect("login.html");
        }
                 response.sendRedirect("homepage.html");

    }

    public void insertingIntoOrderProducts(Integer p)throws ClassNotFoundException, SQLException {
        pi = p;
       
                oi = db.getOrderId(ud);
            
       
            result = db.getPrice(pi);
            while (result.next()) {
                price = result.getInt(1);
            }
 db.updateOrderProducts(oi,pi,price);
        
    }
        public void fun1(Integer p)throws ClassNotFoundException, SQLException {
          
        
            
db.updateOrders(ud);            
        pi = p;
       
                oi = db.getOrderId(ud);
            
       
            result = db.getPrice(pi);
            while (result.next()) {
                price = result.getInt(1);
            }
 db.updateOrderProducts(oi,pi,price);
        
   
    
}
}