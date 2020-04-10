<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <link type="text/css"
              href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<<<<<<< HEAD
        <title>Add new Product</title>
=======
        <title>Add new user</title>
        <style>
            body {
                font-family: Arial, Helvetica, sans-serif;
                background-color: black;
            }
            * {
                box-sizing: border-box;
            }
            
            .container {
                text-align: center;
                padding: 16px;

               
                
                font-style: oblique;
                font-size: 35px;
                font-family: Arial, Helvetica, sans-serif; 
               
            }
            .container2 {
                text-align:right;
                padding: 16px;
                
            }
           
            input[type=text], input[type=number] {
                width: 30%;
                padding: 15px;
                margin: 15px 0 32px 110;
                display: inline-block;
                border: none;
              
                background: #f1f1f1;
            }
            input[type=text]:focus, input[type=number]:focus {
                background-color: #ddd;
                outline: none;
            }
            
            .Submit {
                background-color: rgb(52, 226, 58);
                color: white;
                padding: 16px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 10%;
                opacity: 0.9;
            }
            
        </style>
>>>>>>> 0b797902e7fea853d5a576cdbfe1264874bdabd1
    </head>

 

        <%
        if (!session.getAttribute("admin").equals("yes")) {%>
    <jsp:forward page="/Login.jsp"/>

    <%}%>
    
    <body style="background-color:rgb(92, 141, 104);">


        <form method="POST" action='ProductController' >
            <input  type="text" readonly="readonly" name="productId"  hidden
                    value="<c:out value="${product.p_id}" />" /> <br  /> 
                    <br   />
         <div class="container">
                    Product name </font><input type="text"  name="p_name"  required name="username"
                                  value="<c:out value="${product.p_name}" />" /> <br    />
                                  
                    price       </font>     <input type="number" required name="price"
                        name="price"  
                        value="<c:out value="${product.price}" />" /> <br    /> 
                         
                    category </font> <input
                            type="text" name="category" required name="usename"
                            value="<c:out value="${product.category}" />" /> <br    /> 
               

                    description</font> <input type="text" name="description" required name="usrname"
                                value="<c:out value="${product.description}" />" /> <br    />
                               

                    quantity</font>  <input  type="number" name="quantity"required name="ername"
                            value="<c:out value="${product.quantity}" />" /> <br    />
                           
                           
                            

         </div>
                            <div class="container2">                   
                               <input type="submit" value="Submit" class="Submit" />
            

                            </div>

                
        </form>
    </body>
</html>
