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

    <%
        if (!session.getAttribute("admin").equals("yes")) {%>
    <jsp:forward page="/Login.jsp"/>

    <%}%>



    <body>


        <form method="POST" action='ProductController' enctype="multipart/form-data">
            <input  type="text" readonly="readonly" name="productId"  hidden
                    value="<c:out value="${product.p_id}" />" /> <br  /> 
            Product name : <input type="text"  name="p_name"  required name="username"
                                  value="<c:out value="${product.p_name}" />" /> <br /> 
            price: <input type="number" required name="price"
                          name="price"  
                          value="<c:out value="${product.price}" />" /> <br /> 
            category : <input
                type="text" name="category" required name="usename"
                value="<c:out value="${product.category}" />" /> <br /> 

            description: <input type="text" name="description" required name="usrname"
                                value="<c:out value="${product.description}" />" /> <br />

            quantity <input  type="number" name="quantity"required name="ername"
                             value="<c:out value="${product.quantity}" />" /> <br />

            Add Image <input  type="file" name="image" required name="imagoe"
                              value="<c:out value="${product.image}" />" /> <br />

            <input   type="submit" value="Submit" />
        </form>
    </body>
</html>