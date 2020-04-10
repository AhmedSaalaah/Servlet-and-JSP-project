<%-- 
    Document   : error
    Created on : Apr 7, 2020, 9:02:45 PM
    Author     : ahmed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Error</title>
    </head> 
    <body>
  <h3>Sorry an exception occured!</h3>  
  
Exception is: <%= exception %>
    </body>
</html>
