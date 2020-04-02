

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%          Connection conn;

            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://rogue.db.elephantsql.com:5432/znbgsunx", "znbgsunx", "iOQq0H_2DbCMpqztsAQMNH5VAxNhOAzD");
                System.out.println("Connection is made successfully");
                PreparedStatement t = conn.prepareStatement("insert into users(user_id,username,password,email,is_admin,credit_limit) values (5,?,?,?,false,1000)");
                String uname = request.getParameter("uname");
                String pass = request.getParameter("pass");
                String email = request.getParameter("email");
                t.setString(1, uname);
                t.setString(2, pass);
                t.setString(3, email);
                ResultSet result = t.executeQuery();
                while (result.next()) {
                    System.out.println("Done");
                }

            } catch (SQLException ex) {
//            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
            }

            out.println("Done");%>
    </body>
</html>
