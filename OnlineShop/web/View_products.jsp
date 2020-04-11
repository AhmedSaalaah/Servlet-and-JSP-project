<%-- 
    Document   : View_products
    Created on : Mar 31, 2020, 5:29:34 PM
    Author     : ramr
--%>

<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> View Products </title>
        <link rel="stylesheet" href="try.css">
            <link rel="stylesheet" href="css/all.min.css">
    <link rel="stylesheet" href="css/hider.css">
    </head>
    <body>
        <%@page import="DataBase.Database2" %>
        <%@page import="DataBase.Insert" %>
        
        
        
        <%
                    Database2 db = new Database2();
                    Vector<String[]> User = new Vector();
                    User = db.view_products();
                    int i;
                    String image;%>
                   
                    <% for (i = 0; i < User.size(); i++) {%>
                    
                    <div id="userproduct">
                        
                        <% image=User.elementAt(i)[0];%>
                        <a href="Product_Desc.jsp?name=<%out.println(User.elementAt(i)[1]);%>" target="_blank">
                        <img id="productpic" src= "<% out.println(User.elementAt(i)[0]); %>">
                        
                        <p id="productname"> <% out.println(User.elementAt(i)[1]); %> 
                        </p>
                        <p id="productprice"> <% out.println(User.elementAt(i)[2]); %> </p> </a>
                        
       
                        <input type="button" value="Add to cart" id="productbutton1">
                        
                        
                    </div> 
                        <% } %>
                                             
                    
    </body>
</html>
