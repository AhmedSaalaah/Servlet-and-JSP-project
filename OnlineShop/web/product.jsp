<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link type="text/css"
              href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
        <title>Add new Product</title>
    </head>
        <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: black;
        }

        * {
            box-sizing: border-box;
        }

        input[type=text],
        select,
        textarea {
            width: 50%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }

        input[type=number],
        select,
        textarea {
            width: 50%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }

        label {
            padding: 12px 12px 12px 0;
            display: inline-block;
        }

        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            float: right;
            margin-right: 200px;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        .container {
            border-radius: 5px;
            background-color: #919090;
            padding: 20px;

            font-style: oblique;
                font-size: 15px;
                font-family: Arial, Helvetica, sans-serif; 
        }

        .col-25 {
            float: left;
            width: 25%;
            margin-top: 6px;
        }

        .col-75 {
            float: left;
            width: 75%;
            margin-top: 6px;
        }

        /* Clear floats after the columns */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
        @media screen and (max-width: 600px) {

            .col-25,
            .col-75,
            input[type=submit] {
                width: 100%;
                margin-top: 0;
            }
        }
    </style>


    <%
    if (!session.getAttribute("admin").equals("yes")) {%>
    <jsp:forward page="/Login.jsp"/>

    <%}%>



 <body style="background-color:white">


    <form method="POST" action='ProductController'>
        <input type="text" readonly="readonly" name="productId" hidden value="<c:out value=" ${product.p_id}" />" />
        <br />
        <br />
        <div class="container">
            <font size="8" color="black">Product name </font>
            <input type="text" name="p_name" required name="username" value="<c:out value=" ${product.p_name}" />" />
            <br />
            <br />
            <font size="10" color="black">price </font> <input style="margin-left: 190px;" type="number" required name="price" name="price"
                value="<c:out value=" ${product.price}" />" /> <br />
            <br />
            <font size="8" color="black">category </font> <input style="margin-left: 110px;" type="text" name="category" required name="usename"
                value="<c:out value=" ${product.category}" />" /> <br />
            <br />

            <font size="8" color="black">description</font> <input style="margin-left: 70px;" type="text" name="description" required
                name="usrname" value="<c:out value=" ${product.description}" />" /> <br />
            <br />

            <font size="8" color="black">quantity</font> <input style="margin-left: 135px;" type="number" name="quantity" required name="ername"
                value="<c:out value=" ${product.quantity}" />" /> <br />
            <br />
            Add Image <input  type="file" name="image" required name="imagoe"
                              value="<c:out value="${product.image}" />" /> <br />



        </div>
        <div class="container2">
            <input type="submit" value="Submit" class="Submit" />


        </div>


    </form>
</body></html>