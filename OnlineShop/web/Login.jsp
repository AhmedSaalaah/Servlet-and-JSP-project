<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.io.PrintWriter"%>

        <%
      if(
              session.getAttribute("islogin") ==null ){%>
       
        


<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->


    </head>

    <body>
  

        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100 p-t-50 p-b-90">
                    <form class="login100-form validate-form flex-sb flex-w" action="Login" method="GET">
                        <span class="login100-form-title p-b-51">
                            Login
                        </span>


                        <div class="wrap-input100 validate-input m-b-16" data-validate = "Username is required">
                            <input class="input100" type="text" name="username" placeholder="Username" required name="username"/>
                            <span class="focus-input100"></span>
                        </div>


                        <div class="wrap-input100 validate-input m-b-16" >
                            <input class="input100" type="password" name="pass" placeholder="Password" required name="password"/>
                            <span class="focus-input100"></span>
                        </div>

                        <div class="flex-sb-m w-full p-t-3 p-b-24">
                                
                        </div>

                        <div class="container-login100-form-btn m-t-17">
                            <button class="login100-form-btn">
                                Login
                            </button>
                        </div>
                      
                        <div>
                            <label> If you do not have please <a href="Register.html">Register</a></label>
                            
                        </div>

                    </form>
                </div>
            </div>
        </div>

    </body>
</html>


<%} else  {%> you are already loggined<%}%>