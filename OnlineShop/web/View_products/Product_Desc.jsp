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
        <link rel="stylesheet" href="desc.css">
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

            String n = request.getParameter("name");
           
            db.SQLcommand = "Select * from products where product_name=?";
            db.ps = db.connection.prepareStatement(db.SQLcommand);
            db.ps.setString(1, n);
            db.rs = db.ps.executeQuery();
            while (db.rs.next()) { %>
            <div>
        <img src="<% out.println(db.rs.getString("image"));%>">
        <h2 id="pname"> <% out.println(db.rs.getString("product_name")); %></h2>
        <h2 id="pprice"> Price: <% out.println(db.rs.getString("price")); %></h2>
        <h2 id="pdesc"> <% out.println(db.rs.getString("description")); %></h2>  
        <input type="button" value="Add to cart" id="button">
         </div>

        <%
            }
        %>









    </body>
</html>
