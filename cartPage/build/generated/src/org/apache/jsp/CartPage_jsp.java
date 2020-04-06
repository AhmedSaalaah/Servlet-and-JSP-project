package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import Database.*;

public final class CartPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    Integer ud;
    Integer pi;
    Integer oi;
    Integer price;
    ResultSet rs;
    List<Integer> products;
    Integer oldQuantity=0 ;
    Integer newQuantity =0;
    ConnectDB db = new ConnectDB();
boolean f;
        

     

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/hider2.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');

 
    
    db.connect();
    
    
    if(request!=null && request.getParameter("quantity")!=null &&request.getParameter("order_id")!=null &&request.getParameter("product_id")!= null)
    {
     newQuantity= Integer.parseInt(request.getParameter("quantity"));
     oldQuantity= db.getQuantity(Integer.parseInt(request.getParameter("order_id")),Integer.parseInt(request.getParameter("product_id")));
     if(!newQuantity.equals(oldQuantity)){
        db.updatequantity(Integer.parseInt(request.getParameter("product_id")),Integer.parseInt(request.getParameter("order_id")),newQuantity);

     
    }
    }
//    HttpSession httpSession1 = request.getSession(false);
//    if (httpSession1 != null && httpSession1.getAttribute("IsLogin").equals("true")) { 
      out.write('\n');
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/all.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/hider.css\">\r\n");
      out.write("    \r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\r\n");
      out.write("<link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n");
      out.write("  \r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("   \r\n");
      out.write("  \r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/all.css\">\r\n");
      out.write("   \r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/flaticon.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/themify-icons.css\">\r\n");
      out.write("   \r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("   \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"header\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"leftContent\">\r\n");
      out.write("                <img src=\"img/1.png\" alt=\"\" class=\"phoneIcone\">\r\n");
      out.write("            <div class=\"content\">\r\n");
      out.write("                <p>Need Help</p>\r\n");
      out.write("                <p>123-654-7890</p>\r\n");
      out.write("            </div>\r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"midsContent\">\r\n");
      out.write("                \r\n");
      out.write("                <input class=\"search-box__input\" placeholder=\"Search...\" type=\"text\" name=\"txt_search\" id=\"\">\r\n");
      out.write("                <button type=\"submit\" class=\"search-box__btn\">\r\n");
      out.write("                    <i class=\"fas fa-search\"></i>\r\n");
      out.write("                </button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"rightContent\">\r\n");
      out.write("                <a href=\"https://www.facebook.com/profile.php?id=100006736629924\"><i class=\"fab fa-facebook-f\"></i></a>\r\n");
      out.write("                <a href=\"https://www.twitter.com/\"><i class=\"fab fa-twitter\"></i></a>\r\n");
      out.write("                <a href=\"https://www.instagram.com/\"><i class=\"fab fa-instagram\"></i></a>\r\n");
      out.write("                <a href=\"https://www.linkedin.com/\"><i class=\"fab fa-linkedin-in\"></i></a>\r\n");
      out.write("              \r\n");
      out.write("            </div>\r\n");
      out.write("        \r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- <div class=\"container3\" style=\"background-image: url(img/123.jpg);\">  -->\r\n");
      out.write("            <div class=\"section1\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a href=\"#\">Home</a></li>\r\n");
      out.write("                    <li><a href=\"#\">About Us</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Services</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Contact Us</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("               \r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("   \r\n");
      out.write("    \r\n");
      out.write("\n");
      out.write("<!-- breadcrumb part start-->\n");
      out.write("<section class=\"breadcrumb_part\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-12\">\n");
      out.write("                <div class=\"breadcrumb_iner\">\n");
      out.write("                    <h2>cart list</h2>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</section>\n");
      out.write("<!-- breadcrumb part end-->\n");
      out.write("\n");
      out.write("<!--================Cart Area =================-->\n");
      out.write("<section class=\"cart_area section_padding\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <!-- <div class=\"cart_inner\">\n");
      out.write("          <div class=\"table-responsive\"> -->\n");
      out.write("        <table class=\"table\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th scope=\"col\">Image</th>\n");
      out.write("                    <th scope=\"col\">Product</th>\n");
      out.write("                    <th scope=\"col\">Price</th>\n");
      out.write("                    <th scope=\"col\">Quantity</th>\n");
      out.write("                    <th scope=\"col\"></th>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("\n");
      out.write("\n");
      out.write("                ");

//                    ud = (Integer) httpSession1.getAttribute("user_id");
                    ud = 1;
                    oi = db.getOrderId(ud);

                    products = db.getProductIdsByOrderId(oi);
                    int y = products.size();

                    for (int i = 0; i < y; i++) {

                        rs = db.retriveProductInfo(products.get(i), oi);

                        while (rs.next()) {
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <div class=\"media\">\n");
      out.write("                            <div class=\"d-flex\">\n");
      out.write("                                <img src=  ");
      out.print(rs.getString(1));
      out.write(" \n");
      out.write("                                     />\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <div class=\"media-body\">\n");
      out.write("                            <p> ");
      out.print(rs.getString(2));
      out.write(" </p>\n");
      out.write("                        </div>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <h5> ");
      out.print(rs.getInt(3));
      out.write("</h5>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("             \n");
      out.write("<!--                        <div class=\"product_count\">\n");
      out.write("                            <span class=\"input-number-decrement\"> <i class=\"ti-minus\" onclick=\"decrementValue()\"></i></span>\n");
      out.write("                            <input class=\"input-number\" type=\"text\" id=\"1\" value=\" ");
      out.print(rs.getInt(4));
      out.write("\" min=\"0\" max=\"10\">\n");
      out.write("                            <span class=\"input-number-increment\"> <i class=\"ti-plus\" onclick=\"incrementValue()\" ></i></span>-->\n");
      out.write("\n");
      out.write("<form action=\"#\" >\n");
      out.write("               \n");
      out.write("             <input  type=\"submit\" onclick=\"decrementValue()\"  value=\"-\" class=\"input-number-decrement\">  \n");
      out.write("\n");
      out.write("           <input class=\"input-number\" type=\"number\" id=\"1\"  name =\"quantity\" value=\" ");
      out.print(rs.getInt(4));
      out.write("\" min=\"0\" max=\"10\">\n");
      out.write("             <input type='hidden' name='product_id' value='");
      out.print(products.get(i));
      out.write("' \n");
      out.write("                                   />\n");
      out.write("               <input type='hidden' name='order_id' value= '");
      out.print(oi);
      out.write("'\n");
      out.write("                                   />\n");
      out.write("            <input  type=\"submit\" onclick=\"incrementValue()\"  value=\"+\" class=\"input-number-increment\"> \n");
      out.write("\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                             \n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                            <script>\n");
      out.write("                                function incrementValue()\n");
      out.write("                                {\n");
      out.write("                                    var value = parseInt(document.getElementById('1').value, 10);\n");
      out.write("                                    value = isNaN(value) ? 0 : value;\n");
      out.write("                                    value++;\n");
      out.write("                                    document.getElementById('1').value = value;\n");
      out.write("                                }\n");
      out.write("\n");
      out.write("                            </script>\n");
      out.write("                            <script>\n");
      out.write("                                function decrementValue()\n");
      out.write("                                {\n");
      out.write("                                    var value = parseInt(document.getElementById('1').value, 10);\n");
      out.write("                                    value = isNaN(value) ? 0 : value;\n");
      out.write("                                    value--;\n");
      out.write("                                    document.getElementById('1').value = value;\n");
      out.write("                                }\n");
      out.write("\n");
      out.write("                            </script>\n");
      out.write("                              </form>\n");
      out.write("                        <!--</div>-->\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <form action='remove' method=\"GET\" >\n");
      out.write("\n");
      out.write("                            <input type='hidden' name='product_id' value='");
      out.print(products.get(i));
      out.write("' \n");
      out.write("                                   />\n");
      out.write("                            <input type='hidden' name='order_id' value= '");
      out.print(oi);
      out.write("'\n");
      out.write("                                   />\n");
      out.write("                            <input type='hidden' name='name' value='remove'  />\n");
      out.write("\n");
      out.write("                            <input type='submit'  value='Remove' />\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                ");
    } 
      out.write("\n");
      out.write("                ");
    }
      out.write("\n");
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("</section>\n");
      out.write("<a class=\"btn_1 checkout_btn_1\" href=\"#\">Proceed to checkout</a>\n");
      out.write("<!--================End Cart Area =================-->\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- jquery plugins here-->\n");
      out.write("<script src=\"js/jquery-1.12.1.min.js\"></script>\n");
      out.write("<!-- popper js -->\n");
      out.write("<script src=\"js/popper.min.js\"></script>\n");
      out.write("<!-- bootstrap js -->\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("<!-- easing js -->\n");
      out.write("<script src=\"js/jquery.magnific-popup.js\"></script>\n");
      out.write("<!-- swiper js -->\n");
      out.write("<script src=\"js/swiper.min.js\"></script>\n");
      out.write("<!-- swiper js -->\n");
      out.write("<script src=\"js/mixitup.min.js\"></script>\n");
      out.write("<!-- particles js -->\n");
      out.write("<script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("<script src=\"js/jquery.nice-select.min.js\"></script>\n");
      out.write("<!-- slick js -->\n");
      out.write("<script src=\"js/slick.min.js\"></script>\n");
      out.write("<script src=\"js/jquery.counterup.min.js\"></script>\n");
      out.write("<script src=\"js/waypoints.min.js\"></script>\n");
      out.write("<script src=\"js/contact.js\"></script>\n");
      out.write("<script src=\"js/jquery.ajaxchimp.min.js\"></script>\n");
      out.write("<script src=\"js/jquery.form.js\"></script>\n");
      out.write("<script src=\"js/jquery.validate.min.js\"></script>\n");
      out.write("<script src=\"js/mail-script.js\"></script>\n");
      out.write("<!-- custom js -->\n");
      out.write("<script src=\"js/custom.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
