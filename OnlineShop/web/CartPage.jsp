
<%@page import="java.util.Iterator"%>
<%@page import="DataBase.ConnectDB"%>
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
    Integer oldQuantity = 0;
    Integer newQuantity = 0;
    ConnectDB db = new ConnectDB();
%>
<%
    db.connect();
    if (request != null ) {
        if(request.getParameter("name")!=null && request.getParameter("name").equals("remove"))
        {
           db.remove(Integer.parseInt(request.getParameter("product_id")),Integer.parseInt(request.getParameter("order_id")) );  
        }
        else {
            if(request.getParameter("quantity")!=null &&request.getParameter("order_id")!=null &&request.getParameter("product_id")!=null){
        newQuantity = Integer.parseInt(request.getParameter("quantity"));
        oldQuantity = db.getQuantity(Integer.parseInt(request.getParameter("order_id")), Integer.parseInt(request.getParameter("product_id")));
        if (!newQuantity.equals(oldQuantity)) {
            db.updatequantity(Integer.parseInt(request.getParameter("product_id")), Integer.parseInt(request.getParameter("order_id")), newQuantity);
        }
        }
    }
    }
   HttpSession httpSession1 = request.getSession(false);
  if (httpSession1 != null && httpSession1.getAttribute("islogin").equals("yes")) { %>
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
<%@include file="hider2.html" %>
<!-- breadcrumb part start-->
<section class="breadcrumb_part">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb_iner">
                    <h2>cart list</h2>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- breadcrumb part end-->

<!--================Cart Area =================-->
<section class="cart_area section_padding">
    <div class="container">
        <!-- <div class="cart_inner">
          <div class="table-responsive"> -->
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Image</th>
                    <th scope="col">Product</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col"></th>

                </tr>
            </thead>
            <tbody>


                <%
                    
             ud = (Integer) httpSession1.getAttribute("user_id");
                   
                    oi = db.getOrderId(ud);

                    products = db.getProductIdsByOrderId(oi);
                    int y = products.size();

                    for (int i = 0; i < y; i++) {

                        rs = db.retriveProductInfo(products.get(i), oi);

                        while (rs.next()) {%>


                <tr>
                    <td>
                        <div class="media">
                            <div class="d-flex">
                                <img src=  <%=rs.getString(1)%> 
                                     />
                            </div>

                        </div>
                    </td>
                    <td>
                        <div class="media-body">
                            <p> <%=rs.getString(2)%> </p>
                        </div>
                    </td>
                    <td>
                        <h5> <%=rs.getInt(3)%></h5>
                    </td>
                    <td>

                        <form action="#" >

                            <input  type="submit" onclick="decrementValue()"  value="-" class="input-number-decrement">  

                            <input class="input-number" type="number" id="1"  name ="quantity" value=" <%=rs.getInt(4)%>" min="0" max="10">
                            <input type='hidden' name='product_id' value='<%=products.get(i)%>' 
                                   />
                            <input type='hidden' name='order_id' value= '<%=oi%>'
                                   />
                            <input  type="submit" onclick="incrementValue()"  value="+" class="input-number-increment"> 

                            <script>
                                function incrementValue()
                                {
                                    var value = parseInt(document.getElementById('1').value, 10);
                                    value = isNaN(value) ? 0 : value;
                                    value++;
                                    document.getElementById('1').value = value;
                                }

                            </script>
                            <script>
                                function decrementValue()
                                {
                                    var value = parseInt(document.getElementById('1').value, 10);
                                    value = isNaN(value) ? 0 : value;
                                    value--;
                                    document.getElementById('1').value = value;
                                }

                            </script>
                        </form>
                    </td>
                    <td>
                        <form action='#' >

                            <input type='hidden' name='product_id' value='<%=products.get(i)%>' 
                                   />
                            <input type='hidden' name='order_id' value= '<%=oi%>'
                                   />
                            <input type='hidden' name='name' value='remove'  />

                            <input type='submit'  value='Remove' />
                        </form>
                    </td>
                </tr>

                <%    } %>
                <%    }%>

            </tbody>
        </table>
    </div>
</section>
   <a class="btn_1 checkout_btn_1" href="/OnlineShop/checkout.jsp?order_id=<%=oi%>&user_id=<%=ud%>">Proceed to checkout</a>

<!--================End Cart Area =================-->


<!-- jquery plugins here-->
<script src="js/jquery-1.12.1.min.js"></script>
<!-- popper js -->
<script src="js/popper.min.js"></script>
<!-- bootstrap js -->
<script src="js/bootstrap.min.js"></script>
<!-- easing js -->
<script src="js/jquery.magnific-popup.js"></script>
<!-- swiper js -->
<script src="js/swiper.min.js"></script>
<!-- swiper js -->
<script src="js/mixitup.min.js"></script>
<!-- particles js -->
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<!-- slick js -->
<script src="js/slick.min.js"></script>
<script src="js/jquery.counterup.min.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/contact.js"></script>
<script src="js/jquery.ajaxchimp.min.js"></script>
<script src="js/jquery.form.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/mail-script.js"></script>
<!-- custom js -->
<script src="js/custom.js"></script>
</body>

</html>



<%} 
else{
          response.sendRedirect("Login.jsp");

}%>



