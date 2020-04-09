<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Users</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>product Id</th>
                <th>product Name</th>
                <th>price</th>
                <th>catefory</th>
                <th>description</th>
                <th>quantity</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${products}" var="pro">
                <tr>
                    <td><c:out value="${pro.p_id}" /></td>
                    <td><c:out value="${pro.p_name}" /></td>
                    <td><c:out value="${pro.price}" /></td>
                    <td><c:out value="${pro.category}" /></td>
                    <td><c:out value="${pro.description}" /></td>
                    <td><c:out value="${pro.quantity}" /></td>
                    <td><a href="ProductController?action=edit&productId=<c:out value="${pro.p_id}"/>">Update</a></td>
                    <td><a href="ProductController?action=delete&productId=<c:out value="${pro.p_id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="ProductController?action=insert">Add Product</a></p>
</body>
</html>