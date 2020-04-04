/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Data.User;
import Data.Product;
import Database.ConnectDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ahmed
 */
public class ProductController extends HttpServlet {

    private static String LIST_Products = "/getProductsData.jsp";
    private static String Insert_or_Edit = "/product.jsp";
    ConnectDB con;

    public ProductController() throws ClassNotFoundException {
        super();
        con = new ConnectDB();
        con.connect();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        String admin = (String) session.getAttribute("admin");
        if (admin.equals("yes")) {
            String forward = "";
            String action = req.getParameter("action");

            try {
                if (action.equalsIgnoreCase("delete")) {
                    int productId = Integer.parseInt(req.getParameter("productId"));
                    con.deleteProduct(productId);
                    forward = LIST_Products;
                    req.setAttribute("products", con.getAllProducts());

                } else if (action.equalsIgnoreCase("edit")) {
                    forward = Insert_or_Edit;
                    int productId = Integer.parseInt(req.getParameter("productId"));
                    Product product = con.getProductbyid(productId);
                    req.setAttribute("product", product);
                } else if (action.equalsIgnoreCase("listProduct")) {
                    forward = LIST_Products;
                    req.setAttribute("products", con.getAllProducts());
                } else {
                    forward = Insert_or_Edit;
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            }

            RequestDispatcher view = req.getRequestDispatcher(forward);
            view.forward(req, resp);
        }else{
            
            resp.sendRedirect("Login.html");
        
        }
    }
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Product product = new Product();
            product.p_name = (request.getParameter("p_name"));
            product.price = Integer.parseInt(request.getParameter("price"));
            product.category = (request.getParameter("category"));
            product.description = (request.getParameter("description"));
            product.quantity = Integer.parseInt(request.getParameter("quantity"));
            String productid = request.getParameter("productId");
            if (productid == null || productid.isEmpty()) {
                con.addProduct(product);
            } else {
                product.p_id = Integer.parseInt(productid);
                con.updateProduct(product);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_Products);
        try {
            request.setAttribute("products", con.getAllProducts());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.forward(request, response);
    }
}
