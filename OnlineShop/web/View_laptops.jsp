<%-- 
    Document   : View_laptops
    Created on : Mar 31, 2020, 8:44:32 PM
    Author     : ramr
--%>

<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Laptops </title>
        <link rel="stylesheet" href="try.css">
            <link rel="stylesheet" href="css/all.min.css">
    <link rel="stylesheet" href="css/hider.css">
    </head>
    <body>
        <%@page import="DataBase.Database2" %>
        <%@page import="DataBase.Insert" %>

         <div class="header">
        <div class="container">
            <div class="leftContent">
                <img src="img/1.png" alt="" class="phoneIcone">
            <div class="content">
                <p>Need Help</p>
                <p>123-654-7890</p>
            </div>
                
            </div>
            <div class="midsContent">
                
                <form action="Search_name.jsp" method="GET">
                   
                
                
                <input class="search-box__input" placeholder="Search..." type="text" name="Name">
                <button type="submit" class="search-box__btn" value="Search">
                    <i class="fas fa-search"></i>
                </button>
                 </form>
            </div>
            <div class="rightContent">
                <a href="https://www.facebook.com/profile.php?id=100006736629924"><i class="fab fa-facebook-f"></i></a>
                <a href="https://www.twitter.com/"><i class="fab fa-twitter"></i></a>
                <a href="https://www.instagram.com/"><i class="fab fa-instagram"></i></a>
                <a href="https://www.linkedin.com/"><i class="fab fa-linkedin-in"></i></a>
              
            </div>
        
        </div>
     
            <div class="section1">
                <ul>
                    <li><a href="Home.jsp">Home</a></li>
                    <li><a href="View_products.jsp" > Products </a></li>
                    <li><a href="View_mobiles.jsp"> Mobiles </a></li>
                    <li><a href="View_laptops.jsp"> Laptops </a></li>
                    
           
                </ul>
               
            </div>
            
            
            
        </div>

        <br>
        <div style="background-color: lightblue; display: inline-block;width: 15%; height: 50% ; padding: 1% 1% 1% 1% ; margin-top: 6%;
    margin-left: 2%;border-radius: 7%">

            <form action="laptop_price.jsp" method="GET">

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
            <%
                Database2 db = new Database2();
                Vector<String[]> laptops = new Vector();
                laptops = db.view_Laptops();
                int i;
            String image;

            for (i = 0; i < laptops.size(); i++) {%>

            <div id="userproduct">

                <% image = laptops.elementAt(i)[0];%>
                <a href="Product_Desc.jsp?name=<%out.println(laptops.elementAt(i)[1]);%>" target="_blank">

                    <img id="productpic" src= "<% out.println(laptops.elementAt(i)[0]); %>">
                    <p id="productname"> <% out.println(laptops.elementAt(i)[1]); %> </p>
                    <p id="productprice"> <% out.println(laptops.elementAt(i)[2]); %> </p></a>
                <input type="button" value="Add to cart" id="productbutton1">
            </div>
            <% }%>
    </body>
</html>
