
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import=" java.sql.Connection,java.sql.DriverManager,java.sql.ResultSet,java.io.IOException,java.sql.SQLException,java.sql.Statement,java.util.logging.Level,java.util.logging.Logger,javax.servlet.ServletException,javax.servlet.http.HttpServlet, Database.*" %>
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

<%@include file="hider2.html" %>
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
