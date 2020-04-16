<%@page import="DataBase.ConnectDB" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import=" java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    Integer ud;
    Integer pi;
    Integer oi;
    Integer price;
    ResultSet rs;
    List<Integer> products;
    Integer total = 0;
    Integer credit = 0;
    ConnectDB db = new ConnectDB();
    int updated_credit;
    int updated_quantity;
    int y;
%>
<%
    db.connect();
    if (request != null) {
        if (request.getParameter("name") != null && request.getParameter("name").equals("order")) {
            if (credit >= total) {
                db.SetOrder(total, oi);
                updated_credit = credit - total;
                db.updateUserCredit(updated_credit, ud);
                products = db.getProductIdsByOrderId(oi);
                int y = products.size();
                for (int i = 0; i < y; i++) {
                    rs = db.retriveProductInfo(products.get(i), oi);
                    while (rs.next()) {
                        updated_quantity = rs.getInt(6) - rs.getInt(4);
                        db.updateProductQuantity(updated_quantity, products.get(i));
                          response.sendRedirect("ordersuccess.jsp");

                     }
                }
            } else {
              response.sendRedirect("orderfailed.jsp");

           }

        } else if(request.getParameter("name") != null && request.getParameter("name").equals("edit")){
          updated_credit=Integer.parseInt(request.getParameter("updated_credit")); 
           db.updateUserCredit(updated_credit, ud);
            credit = db.getCreditLimit(ud);
        }
        else {
//    HttpSession httpSession1 = request.getSession(false);
//   if (httpSession1 != null && httpSession1.getAttribute("IsLogin").equals("true")) {
            oi = Integer.parseInt(request.getParameter("order_id"));
            ud = Integer.parseInt(request.getParameter("user_id"));
            products = db.getProductIdsByOrderId(oi);
            y = products.size();
            credit = db.getCreditLimit(ud);
        }
    }
%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title> Home </title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/all.min.css">
        <link rel="stylesheet" href="css/hider.css">

    </head>

    <body>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="css/all.min.css">
    <link rel="stylesheet" href="css/hider.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  
    <link rel="stylesheet" href="css/bootstrap.min.css">
   
  
    <link rel="stylesheet" href="css/all.css">
   
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/themify-icons.css">
   
    <link rel="stylesheet" href="css/style.css">
      
    <link rel="stylesheet" href="css1/bootstrap.min.css">
   
  
    <link rel="stylesheet" href="css1/all.css">
   
    <link rel="stylesheet" href="css1/flaticon.css">
    <link rel="stylesheet" href="css1/themify-icons.css">
   
    <link rel="stylesheet" href="css1/style.css">
        <link rel="stylesheet" href="css1/all.min.css">
    <link rel="stylesheet" href="css1/hider.css">
   
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
                
                <input class="search-box__input" placeholder="Search..." type="text" name="txt_search" id="">
                <button type="submit" class="search-box__btn">
                    <i class="fas fa-search"></i>
                </button>
            </div>
            <div class="rightContent">
                <a href="https://www.facebook.com/profile.php?id=100006736629924"><i class="fab fa-facebook-f"></i></a>
                <a href="https://www.twitter.com/"><i class="fab fa-twitter"></i></a>
                <a href="https://www.instagram.com/"><i class="fab fa-instagram"></i></a>
                <a href="https://www.linkedin.com/"><i class="fab fa-linkedin-in"></i></a>
              
            </div>
        
        </div>
        <!-- <div class="container3" style="background-image: url(img/123.jpg);">  -->
            <div class="section1" >
                <ul>
                    <li><a href="Home.jsp">Home</a></li>
                    <li><a href="View_products.jsp" > Products </a></li>
                    <li><a href="View_mobiles.jsp"> Mobiles </a></li>
                    <li><a href="View_laptops.jsp"> Laptops </a></li>
                    <li><a href="CartPage.jsp" > Cart</a></li>
                    <li><a href="Logout"> Logout </a></li>
                </ul>
               
            </div>
<div id="breadcrumb" class="section">

    <div >

        <div class="row">
            <div class="col-md-12">
                <h3  class="breadcrumb-header">Checkout</h3> <br>

            </div>
        </div>

    </div>

</div>
</div>
<div class="section">
    <!-- container -->
    <div >
        <!-- row -->
        <div class="row">

            <div class="col-md-7">


                <!-- Order Details -->
                <div class="col-md-5 order-details">
                    <div class="section-title text-center">
                        <h3 class="title">Your Order</h3>
                    </div>
                    <div class="order-summary">
                        <div class="order-col">
                            <div><strong>PRODUCT</strong></div>
                            <div><strong>TOTAL</strong></div>
                        </div>
                        <%
                            total=0;
                            for (int i = 0; i < y; i++) {

                                rs = db.retriveProductInfo(products.get(i), oi);

                                while (rs.next()) {%>

                        <div class="order-products">
                            <div class="order-col">
                                <div><%=rs.getInt(4)%> x  <%=rs.getString(2)%></div>
                                <div><%=(rs.getInt(4)) * (rs.getInt(3))%></div>
                                <%    total = total + ((rs.getInt(4)) * (rs.getInt(3))); %>
                            </div>



                            <%    } %>
                            <%    }%>

                        </div>
                        <div class="order-col">
                            <div><strong>TOTAL</strong></div>
                            <div><strong class="order-total"> <%= total%></strong></div>
                        </div>
                    </div>


       <a class="primary-btn order-submit" href="checkout.jsp?name=order">Place order</a>
                </div>
                <!-- /Order Details -->
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /SECTION -->

    <div class="billing-details">
        <div class="section-title">
            <h3 class="title">Credit Limit </h3>

        </div>
        <div >
            <h5>  <%= credit%></h5>
        </div>
    </div>
  <form  action="#" >
      <input  class="title form-group input" type='text' name='updated_credit' placeholder="Enter your updated_credit"  /><br>
      <input type='submit' value='edit'  <a class="primary-btn order-submit" href="#"/>  

                          
 <input type='hidden' name='name' value='edit'  />
</form>
</div>
</div>


<!-- jQuery Plugins -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/nouislider.min.js"></script>
<script src="js/jquery.zoom.min.js"></script>
<script src="js/main.js"></script>

</body>
</html>








<!--   //  } 
//else{
 //           response.sendRedirect("login.html");

//}-->
