<%-- 
    Document   : View_mobiles
    Created on : Mar 31, 2020, 8:44:21 PM
    Author     : ramr
--%>

<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Mobiles </title>
          <link rel="stylesheet" href="try.css">
    </head>
    <body>
        <%@page import="DataBase.Database2" %>
        <%@page import="DataBase.Insert" %>
           <header>
            <div style="background-color: lightgray; height: 30%; padding-top: 2%;padding-bottom: 2%"> 
                <a href="HOme_trial.jsp" style="color: white ; font-size: 25px"> Home </a>
                &nbsp; &nbsp; &nbsp;<a href="View_products.jsp"style="font-size: 25px; color: white"> Products </a>

            </div>
        </header>
        
         <%
                    Database2 db = new Database2();
                    Vector<String[]> mobiles = new Vector();
                    mobiles = db.view_Mobiles();
                    int i;
                    String image;%>
                   
                   
                    <% for (i = 0; i < mobiles.size(); i++) {%>
                    
                    <div id="userproduct">
                        
                        <% image=mobiles.elementAt(i)[0];%>
                        <a href="Product_Desc.jsp?name=<%out.println(mobiles.elementAt(i)[1]);%>" target="_blank">
                        <img id="productpic" src= "<% out.println(mobiles.elementAt(i)[0]); %>">
                        <p id="productname"> <% out.println(mobiles.elementAt(i)[1]); %> </p>
                        <p id="productprice"> <% out.println(mobiles.elementAt(i)[2]); %> </p>
                        </a>
                        <input type="button" value="Add to cart" id="productbutton1">
                        
                        
                    </div> 
                        <% } %>
    </body>
</html>
