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
        <link rel="stylesheet" href="css/all.min.css">
        <link rel="stylesheet" href="css/hider.css">
    </head>
    <body>


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

        <%
            Database2 db = new Database2();
            db.connect();

            int i;
            String image;

            String n = request.getParameter("Name");
            db.SQLcommand = "Select * from products where product_name ILIKE ?";
            db.ps = db.connection.prepareStatement(db.SQLcommand);
            db.ps.setString(1, "%" + n + "%");
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
