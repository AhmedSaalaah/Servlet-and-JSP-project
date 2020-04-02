

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
                PreparedStatement t = conn.prepareStatement(" select * from users where username =? and password=?");
                String uname = request.getParameter("uname");
                String pass = request.getParameter("pass");

                t.setString(1, uname);
                t.setString(2, pass);

                ResultSet result = t.executeQuery();
                while (result.next()) {
                    if (result.getString(5).equals("t")) {
                        out.println("Welcome ya " + result.getString(2) + " you are admin");
                    } else if (result.getString(5).equals("f")) {
                        out.println("Welcome ya " + result.getString(2) + " you are client");
                    }
                }

            } catch (SQLException ex) {
//            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
            }

        %>
    </body>
</html>