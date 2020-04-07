<%-- 
    Document   : Product_Desc
    Created on : Mar 31, 2020, 9:59:18 PM
    Author     : ramr
--%>

<%@page import="java.util.Vector"%>
<%@page import="java.lang.String"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DataBase.Database2" %>
<%@page import="DataBase.Insert" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="stylesheet" href="try.css">
    </head>
    <body>
        
        
           <header>
            <div style="background-color: lightgray; height: 30%; padding-top: 2%;padding-bottom: 2%"> 
                <a href="HOme_trial.jsp" style="color: white ; font-size: 25px"> Home </a>
                &nbsp; &nbsp; &nbsp;<a href="View_products.jsp"style="font-size: 25px; color: white"> Products </a>

            </div>
        </header>

        <%
            Database2 db = new Database2();
            db.connect();

            int i;
            String image;

            String n = request.getParameter("rangeInput");
             int z = Integer.parseInt(n);         
            db.SQLcommand = "Select * from products where price <= ?";
            db.ps = db.connection.prepareStatement(db.SQLcommand);
            db.ps.setInt(1,z);
            db.rs = db.ps.executeQuery();
            %>
           
            <%
            while (db.rs.next()) { %>
            <div id="userproduct">
                 <a href="Product_Desc.jsp?name=<% out.println(db.rs.getString("product_name")); %>" target="_blank">
        <img src="<% out.println(db.rs.getString("image"));%>" id="productpic">
        <p id="productname"> <% out.println(db.rs.getString("product_name")); %></p>
        <p id="productprice"> Price: <% out.println(db.rs.getString("price")); %></p> </a>
        <input type="button" value="Add to cart" id="productbutton1">
         </div>

        <%
            }
        %>
       








    </body>
</html>
