package addtocart;

import database.Database;
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

    @Override
    public void init() throws ServletException {
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(addToCart.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/onlineshop", "postgres", "1234");
        } catch (SQLException ex) {
            Logger.getLogger(addToCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession1 = request.getSession(false);
        if (httpSession1 != null && httpSession1.getAttribute("IsLogin").equals("true")) {
            ud = (Integer) httpSession1.getAttribute("user_id");
            sqlCommand = "select user_id from orders where user_id=' " + ud + "'";
            try {
                st = conn1.createStatement();
                result = st.executeQuery(sqlCommand);
                PrintWriter out = response.getWriter();
                if (!result.next() == false) {
                    int i = 0;
                    sqlCommand = "select user_id ,date  from orders where user_id=' " + ud + "'";
                    st = conn1.createStatement();
                    result = st.executeQuery(sqlCommand);
                    while (result.next()) {
                        if (result.getString(2) != null) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                    }
                    if (i == 1) {

                        pi = Integer.parseInt(request.getParameter("product_id"));
                        fun1(pi);
                    } else {
                        pi = Integer.parseInt(request.getParameter("product_id"));
                        insertingIntoOrderProducts(pi);
                    }
                } else {

                    pi = Integer.parseInt(request.getParameter("product_id"));
                    fun1(pi);
                }
            } catch (SQLException ex) {
                Logger.getLogger(addToCart.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            response.sendRedirect("login.html");
        }
    }

    public void insertingIntoOrderProducts(Integer p) {
        pi = p;
        sqlCommand = "select order_id from orders where  user_id= " + ud + " and date IS NULL";
        try {
            st = conn1.createStatement();
            result = st.executeQuery(sqlCommand);
            while (result.next()) {
                oi = result.getInt(1);
            }
            sqlCommand = "select price from products where  product_id='" + pi + "'";
            st = conn1.createStatement();
            result = st.executeQuery(sqlCommand);
            while (result.next()) {
                price = result.getInt(1);
            }
            sqlCommand = "insert into order_products  Values (?,?,?,?)";
            preparedStatment = conn1.prepareStatement(sqlCommand);
            preparedStatment.setInt(1, pi);
            preparedStatment.setInt(2, oi);
            preparedStatment.setInt(3, 1);
            preparedStatment.setInt(4, price);
            preparedStatment.execute();
        } catch (SQLException ex) {
        }
    }
        public void fun1(Integer p) {
          
        
            
            sqlCommand = "insert into orders  (user_id)  values ('" + ud + "')";
            
            try {
                st = conn1.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(addToCart.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                st.executeQuery(sqlCommand);
            } catch (SQLException ex) {
                Logger.getLogger(addToCart.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.err.println("eroooooooorrr1");
        pi = p;
        sqlCommand = "select order_id from orders where  user_id= " + ud + " and date IS NULL";
        try {
            st = conn1.createStatement();
            result = st.executeQuery(sqlCommand);
            while (result.next()) {
                oi = result.getInt(1);
            }
            sqlCommand = "select price from products where  product_id='" + pi + "'";
            st = conn1.createStatement();
            result = st.executeQuery(sqlCommand);
            while (result.next()) {
                price = result.getInt(1);
            }
            sqlCommand = "insert into order_products  Values (?,?,?,?)";
            preparedStatment = conn1.prepareStatement(sqlCommand);
            preparedStatment.setInt(1, pi);
            preparedStatment.setInt(2, oi);
            preparedStatment.setInt(3, 1);
            preparedStatment.setInt(4, price);
            preparedStatment.execute();
        } catch (SQLException ex) {
        }
        
   
    
}
}