<%-- 
    Document   : HOme_trial
    Created on : Apr 3, 2020, 5:41:50 PM
    Author     : ramr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Home Page </title>
    </head>
    <body>
        <header>
            <div style="background-color: lightgray; height: 30%; padding-top: 2%;padding-bottom: 2%"> 
                <a href="HOme_trial.jsp" style="color: white ; font-size: 25px"> Home </a>
                &nbsp; &nbsp; &nbsp;<a href="View_products.jsp"style="font-size: 25px; color: white"> Products </a>

            </div>
        </header>
        <br>
        <br>
        <br>
        <br>
        <div>
            <div style="background-color: lightblue; display: inline-block;width: 15%; height: 50% ; padding: 1% 1% 1% 1%">

                <h2 style="color: white"> Categories </h2>
                <a href="View_mobiles.jsp" style="color: white ; font-size: 25px"> Mobiles </a><br>
                <a href="View_laptops.jsp"style="font-size: 25px; color: white"> Laptops </a>
                <br>
                <br>
                <br>
                <form action="Search_price.jsp" method="GET">
                   
                    
                <label style="color: white ; font-size: 25px"> Select price range </label> <br>

                <input type="range" id="rangeInput" name="rangeInput" min="0" max="20000" value="0"
                       oninput="amount.value=rangeInput.value" formaction="View_products.jsp?price=rangeInput.value">                                                       

                <output id="amount" name="amount" for="rangeInput" style="color: white"> 0 </output> 
                <input type ="submit" value="Search"></form>
                
                <br>
                <br>
                <form action="Search_name.jsp" method="GET">
                    Search By Name: <input type="text" name="Name">
                    <input type ="submit" value="Search"></form>
                <br>
                <br>
                <br>
                <br>

            </div>
            <div style="display: inline-block; width: 70%; margin-left: 10%">
                <jsp:include page="View_products.jsp"></jsp:include>
            </div>
        </div>


        <footer style="background-color: black"></footer>
    </body>
</html>
