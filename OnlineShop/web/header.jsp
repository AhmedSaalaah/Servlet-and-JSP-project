<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/all.min.css">
    <link rel="stylesheet" href="css/hider.css">
   
</head>
<body>
    <div class="header">
            <div class="section1">
                <ul>
                    <li>welcome <%=session.getAttribute("username")%></li>
                    <li><a href="indexusers.jsp">List Customers</a></li>
                    <li><a href="indexProducts.jsp">List product</a></li>
                    <li><a href="ProductController?action=insert" > Add Product</a></li>
                    <li><a href="Logout" > Logout</a></li>
                </ul>
            </div>
        </div>
    
  
</body>
</html>
<br><br><br><br><br><br><br><br>