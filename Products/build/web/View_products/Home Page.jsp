<%-- 
    Document   : Home Page
    Created on : Apr 2, 2020, 10:40:51 PM
    Author     : ramr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@page import="DataBase.Database2" %>
 <%@page import="DataBase.Insert" %>
 
 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
        crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">

</head>

<body>
    <!-- header -->
    <div class="header">
        <!-- upper header -->
        <div class="header__upper">
            <!-- container -->
            <div class="container">
               
                <!-- side menu -->
                <ul class="list list--hr">
                    <li class="list__item">
                        <a href="#" class="link">
                            <!-- icon -->
                            <i class="link__icon fas fa-angle-right"></i>
                            <!-- info -->
                            Login
                        </a>
                    </li>
                    <li class="list__item">
                        <a href="#" class="link">
                            <!-- icon -->
                            <i class="link__icon fas fa-angle-right"></i>
                            <!-- info -->
                            Register
                        </a>
                    </li>
                    <!-- languges -->
                    <li class="list__item">
                        <!-- drop down -->
                        <!-- to oppen dropdown dropdown--opened -->
                        <div class="dropdown ">
                            <!-- header -->
                            <!-- items -->
                            <div class="dropdown__body">
                                <ul class="dropdown__items list">
                                    <li class="dropdown__item list__item">
                                        <a href="#" class="link">
                                            <img class="flag flag-us" src="" alt="">
                                            English
                                        </a>
                                    </li>
                                    <li class="dropdown__item list__item">
                                        <a href="#" class="link">
                                            <img class="flag flag-es" src="" alt="">
                                            Español
                                        </a>
                                    </li>
                                    <li class="dropdown__item list__item">
                                        <a href="#" class="link">
                                            <img class="flag flag-fr" src="" alt="">
                                            Française
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <!-- middle header -->
        <div class="header__middle container">
            <!-- logo -->
            <a href="#" class="header__logo-box">
                <img class="header__logo" src="img/logo.png" alt="">
            </a>
            <!-- user options -->
            <div class="header__user-options">
                <!-- login control -->
                <div class="dropdown">
                        
                    </div>
                    <div class="dropdown__body">

                    </div>
                </div>
                <!-- shopping card dropdown -->
                <!-- dropdown--opened to open -->
                <div class="dropdown dropdown--left  ">
                    <!-- header -->
                  
                    <!-- body -->
                    <div class="dropdown__body">
                        <!-- items -->
                        <ul class="dropdown__items list list--vr-separator">
                            <li class="dropdown__item list__item">
                                <!-- item small 2 -->
                                <div class="item-small-1">
                                    <!-- item data -->
                                    <div class="item-small-1__data">
                                        <!-- title -->
                                        <a href="" class="item-small-1__title">Camera X1000</a>
                                        <!-- price -->
                                        <span class="item-small-1__description">
                                            1 X $890
                                        </span>
                                    </div>
                                    <!-- item image -->
                                    <div class="item-small-1__image-box">
                                        <a href="#" class="item-small-1__image image" style="background-image: url('img/products/product-1.jpg')">
                                        </a>
                                        <a href="#" class="item-small-1__action">
                                            <i class="fas fa-times"></i>
                                        </a>
                                    </div>
                                </div>
                            </li>
                            <li class="dropdown__item list__item">
                                <div class="item-small-1">
                                    <!-- item data -->
                                    <div class="item-small-1__data">
                                        <!-- title -->
                                        <a href="" class="item-small-1__title">Camera X2000</a>
                                        <!-- price -->
                                        <span class="item-small-1__description">
                                            2 X $990
                                        </span>
                                    </div>
                                    <!-- item image -->
                                    <div class="item-small-1__image-box">
                                        <a href="#" class="item-small-1__image image" style="background-image: url('img/products/product-1.jpg')">
                                        </a>
                                        <a href="" class="item-small-1__action">
                                            <i class="fas fa-times"></i>
                                        </a>
                                    </div>
                                </div>
                            </li>
                        </ul>
                        <!-- totals -->
                        <div class="separator"></div>
                        <div class="block">
                            <span class="lable">Total:</span>
                            <span class="lable">$2870</span>
                        </div>
                        <!-- actions -->
                        <div class="block list list--hr">
                            <a class="list-item btn btn--gray" href="">View Cart</a>
                            <a class="list-item btn btn--primary" href="">Checkout</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- lower header -->
        <div class="header__lower container">
            <!-- navigation -->
            <nav class="nav">
                <ul class="nav__items list list--hr">
                    <!-- items -->
                    <li class="nav__item">
                        <a class="nav__link" href="#">Home</a>
                    </li>
                    <li class="nav__item dropdown ">
                        <!-- title -->
                        <a class="nav__link dropdown__header" href="#">
                            Products
                        </a>
                        <!-- items -->
                        <div class="dropdown__body">
                            <ul class=" list">
                                
                                <li class="list__item">
                                    <a class="nav__inner-link" href="#">Add Product</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <!-- Listing Items -->
    <div class="container">
        <!-- filters -->
        <section class="filters">
            <!-- search box -->
            <div class="search-box">
                <input class="search-box__input" placeholder="Search..." type="text" name="txt_search">
                <button type="submit" class="search-box__btn" formaction="../View_products/Search_name.jsp">
                    <i class="fas fa-search"></i>
                </button>
            </div>
            <!-- filter list -->
            <div>
                <!-- filter header -->
                <h5>Categories</h5>
                <!-- filter list -->
                <ul class="list list--vr-separator">
                    <li class="link list__item"><i class="link__icon fas fa-angle-right"></i>
                        <a href="../View_products/View_mobiles.jsp" target="_blank">Mobiles</a></li>
                    <li class="link list__item"><i class="link__icon fas fa-angle-right"></i>
                        <a href="../View_products/View_laptops.jsp" target="_blank">Laptops</a></li>
                 
                </ul>
            </div>
            
       
        </section>
        <!-- Items -->
        <section class="item-listing">
            <jsp:include page="View_products.jsp"></jsp:include>
 
            
        </section>
    </div>

</body>

</html>