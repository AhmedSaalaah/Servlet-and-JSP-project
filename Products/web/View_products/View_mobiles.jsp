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
           <br>
        
         <%
                    Database2 db = new Database2();
                    Vector<String[]> mobiles = new Vector();
                    mobiles = db.view_Mobiles();
                    int i;
                    String image;%>
                           <div style="background-color: lightblue; display: inline-block;width: 15%; height: 50% ; padding: 1% 1% 1% 1%">

         
               
                 <form action="Mobile_price.jsp" method="GET">
                <label style="color: white ; font-size: 25px"> Select Max. price range </label> <br>

                <input type="range" id="rangeInput" name="rangeInput" min="0" max="20000" value="0"
                       oninput="amount.value=rangeInput.value" formaction="Mobile_price.jsp">                                                       

                <output id="amount" name="amount" for="rangeInput" style="color: white"> 0 </output> 
                <input type ="submit" value="Search"></form>
                
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>

            </div>
                   
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
