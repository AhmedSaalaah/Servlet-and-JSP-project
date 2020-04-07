<%-- 
    Document   : getuserData
    Created on : Apr 2, 2020, 12:53:28 AM
    Author     : ahmed
<% ConnectDB db = new ConnectDB();
    Vector<User> users = db.getAllUsers();

    for (User usr : users) {

%>
<%= usr.username%> 
<%= usr.pass%> 



<%}%> 
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.util.Vector"%>
<%@page import="Database.ConnectDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Data.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>


    
    
    <body>
     
        welcome <%=session.getAttribute("username")%>
      
        <table border=1>
            <thead>
                <tr>
                    <th>User Id</th>
                    <th>username</th>
                    <th>password</th>
                    <th>Email</th>
                    <th>Credit</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
              
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td><c:out value="${user.id}" /></td>
                        <td><c:out value="${user.username}" /></td>
                        <td><c:out value="${user.pass}" /></td>
                        <td><c:out value="${user.email}" /></td>
                        <td><c:out value="${user.credit_limit}" /></td>
                        <td><a href="UserController?action=delete&userId=<c:out value="${user.id}"/>">Delete</a></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div style="text-align: left"><a href="<%=request.getContextPath()%>/Logout">Logout</a></div>

    </body>
</html>
