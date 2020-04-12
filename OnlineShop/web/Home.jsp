
<% if (session.getAttribute("user") ==null) {%>

<jsp:forward page="Login.jsp"/>
<%}else{%>

<%=session.getAttribute("user_id")%>
<%=session.getAttribute("username")%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title> Home </title>
        <link rel="stylesheet" href="css/all.min.css">
        <link rel="stylesheet" href="css/hider.css">
            
    </head>
    
    <body>
        <div class="header">
            <div class="container">
                <div class="leftContent">
                    <img src="img/1.png" alt="" class="phoneIcone">
                    <div class="content">
                        <p>Need Help</p>
                        <p>123-654-7890</p>
                    </div>

                </div>
                <div class="midsContent">

                    <form action="Search_name.jsp" method="GET">

                        <input class="search-box__input" placeholder="Search..." type="text" name="Name">
                        <button type="submit" class="search-box__btn" value="Search">
                            <i class="fas fa-search"></i>
                        </button>
                    </form>
                    <br><br>

                    <form action="Search_price.jsp" method="GET">


                        <label style="font-size: 15px"> Select Max. price range </label> &nbsp; &nbsp;

                        <input type="range" id="rangeInput" name="rangeInput" min="0" max="20000" value="0"
                               oninput="amount.value=rangeInput.value" formaction="View_products.jsp?price=rangeInput.value">                                                       

                        <output id="amount" name="amount" for="rangeInput"> 0 </output> <br>
                        <input type ="submit" value="Search"></form>
                </div>
                <div class="rightContent">
                    <a href="https://www.facebook.com/profile.php?id=100006736629924"><i class="fab fa-facebook-f"></i></a>
                    <a href="https://www.twitter.com/"><i class="fab fa-twitter"></i></a>
                    <a href="https://www.instagram.com/"><i class="fab fa-instagram"></i></a>
                    <a href="https://www.linkedin.com/"><i class="fab fa-linkedin-in"></i></a>
                    <a href="CartPage.jsp" > <img id="cart" src="images/icons/cart.png" ></a>
                </div>

            </div>

            <div class="section1">
                <ul>
                    <li><a href="Home.jsp">Home</a></li>
                    <li><a href="View_products.jsp" > Products </a></li>
                    <li><a href="View_mobiles.jsp"> Mobiles </a></li>
                    <li><a href="View_laptops.jsp"> Laptops </a></li>
                    <li><a href="Logout"> Logout </a></li>
                    

                </ul>

            </div>

        </div>

        <div style="display: inline-block; width: 70%; margin-left: 10%">
            <jsp:include page="View_products.jsp"></jsp:include>
        </div>


    </body>
</html>
<%}%>