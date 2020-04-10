/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Data.User;
import Data.Product;
import DataBase.ConnectDB;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
=======
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
>>>>>>> 10820709941cda5c33b240eb10181f887c74b4cc

/**
 *
 * @author ahmed
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)

public class ProductController extends HttpServlet {

    private static String LIST_Products = "/getProductsData.jsp";
    private static String Insert_or_Edit = "/product.jsp";
    private final static String UPLOAD_DIR = "Images";
    public static String dbFileName = "";
    ConnectDB con;
   

    public ProductController() throws ClassNotFoundException {
        super();
        con = new ConnectDB();
        con.connect();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward = "";
        String action = req.getParameter("action");

<<<<<<< HEAD
        try {
            if (action.equalsIgnoreCase("delete")) {
                int productId = Integer.parseInt(req.getParameter("productId"));
                con.deleteProduct(productId);
                forward = LIST_Products;
                req.setAttribute("products", con.getAllProducts());
=======
        HttpSession session = req.getSession(false);
        String admin = (String) session.getAttribute("admin");
        if (null != admin && admin.equals("yes")) {
            String forward = "";
            String action = req.getParameter("action");

            try {
                if (action.equalsIgnoreCase("delete")) {
                    int productId = Integer.parseInt(req.getParameter("productId"));
                    con.deleteProduct(productId);
                    forward = LIST_Products;
                    req.setAttribute("products", con.getAllProducts());
>>>>>>> 10820709941cda5c33b240eb10181f887c74b4cc

            } else if (action.equalsIgnoreCase("edit")) {
                forward = Insert_or_Edit;
                int productId = Integer.parseInt(req.getParameter("productId"));
                Product product = con.getProductbyid(productId);
                req.setAttribute("product", product);
            } else if (action.equalsIgnoreCase("listProduct")) {
                forward = LIST_Products;
                req.setAttribute("products",con.getAllProducts());
            } else {
                forward = Insert_or_Edit;
            }
<<<<<<< HEAD
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
=======

            RequestDispatcher view = req.getRequestDispatcher(forward);
            view.forward(req, resp);
        } else {

            resp.sendRedirect("Login.jsp");

>>>>>>> 10820709941cda5c33b240eb10181f887c74b4cc
        }

        RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
       try{
        Product product = new Product();
        product.p_name=(request.getParameter("p_name"));
        product.price=Integer.parseInt(request.getParameter("price"));
        product.category=(request.getParameter("category"));
        product.description=(request.getParameter("description"));
        product.quantity=Integer.parseInt(request.getParameter("quantity"));
        String productid = request.getParameter("productId");
        if (productid == null || productid.isEmpty()) {
            con.addProduct(product);
        } else{
            product.p_id=Integer.parseInt(productid);
            con.updateProduct(product);
        }
    
       } catch (ClassNotFoundException | SQLException ex) {
=======
        try {

            Product product = new Product();
            product.p_name = (request.getParameter("p_name"));
            product.price = Integer.parseInt(request.getParameter("price"));
            product.category = (request.getParameter("category"));
            product.description = (request.getParameter("description"));
            product.quantity = Integer.parseInt(request.getParameter("quantity"));
           
            Part part = request.getPart("image");
            String fileName = extractFileName(part);
            String applicationPath = getServletContext().getRealPath("");
            String uploadPath = applicationPath + UPLOAD_DIR;
            System.out.println("applicationPath:" + applicationPath);
            File fileUploadDirectory = new File(uploadPath);
            if (!fileUploadDirectory.exists()) {
                fileUploadDirectory.mkdirs();
            }
            String savePath = uploadPath + File.separator + fileName;
            System.out.println("savePath: " + savePath);
            String sRootPath = new File(savePath).getAbsolutePath();
            System.out.println("sRootPath: " + sRootPath);
            part.write(savePath + File.separator);
            File fileSaveDir1 = new File(savePath);
            dbFileName = UPLOAD_DIR + File.separator + fileName;
            System.out.println(dbFileName);
            part.write(savePath + File.separator);

            String productid = request.getParameter("productId");
            if (productid == null || productid.isEmpty()) {
                con.addProduct(product);
            } else {
                product.p_id = Integer.parseInt(productid);
                con.updateProduct(product);
            }

        } catch (ClassNotFoundException | SQLException ex) {
>>>>>>> 10820709941cda5c33b240eb10181f887c74b4cc
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_Products);
        try {
<<<<<<< HEAD
=======

>>>>>>> 10820709941cda5c33b240eb10181f887c74b4cc
            request.setAttribute("products", con.getAllProducts());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
<<<<<<< HEAD
        view.forward(request, response);
=======

        view.forward(request, response);

>>>>>>> 10820709941cda5c33b240eb10181f887c74b4cc
    }

    private String extractFileName(Part part) {//This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    public static void main(String[] args) throws ClassNotFoundException {

    }

}

