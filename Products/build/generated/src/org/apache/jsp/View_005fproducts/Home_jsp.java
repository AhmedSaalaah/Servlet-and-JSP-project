package org.apache.jsp.View_005fproducts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <title> Home </title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/hider.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"leftContent\">\n");
      out.write("                    <img src=\"img/1.png\" alt=\"\" class=\"phoneIcone\">\n");
      out.write("                    <div class=\"content\">\n");
      out.write("                        <p>Need Help</p>\n");
      out.write("                        <p>123-654-7890</p>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"midsContent\">\n");
      out.write("\n");
      out.write("                    <form action=\"Search_name.jsp\" method=\"GET\">\n");
      out.write("\n");
      out.write("                        <input class=\"search-box__input\" placeholder=\"Search...\" type=\"text\" name=\"Name\">\n");
      out.write("                        <button type=\"submit\" class=\"search-box__btn\" value=\"Search\">\n");
      out.write("                            <i class=\"fas fa-search\"></i>\n");
      out.write("                        </button>\n");
      out.write("                    </form>\n");
      out.write("                    <br><br>\n");
      out.write("\n");
      out.write("                    <form action=\"Search_price.jsp\" method=\"GET\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <label style=\"font-size: 15px\"> Select Max. price range </label> &nbsp; &nbsp;\n");
      out.write("\n");
      out.write("                        <input type=\"range\" id=\"rangeInput\" name=\"rangeInput\" min=\"0\" max=\"20000\" value=\"0\"\n");
      out.write("                               oninput=\"amount.value=rangeInput.value\" formaction=\"View_products.jsp?price=rangeInput.value\">                                                       \n");
      out.write("\n");
      out.write("                        <output id=\"amount\" name=\"amount\" for=\"rangeInput\"> 0 </output> <br>\n");
      out.write("                        <input type =\"submit\" value=\"Search\"></form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"rightContent\">\n");
      out.write("                    <a href=\"https://www.facebook.com/profile.php?id=100006736629924\"><i class=\"fab fa-facebook-f\"></i></a>\n");
      out.write("                    <a href=\"https://www.twitter.com/\"><i class=\"fab fa-twitter\"></i></a>\n");
      out.write("                    <a href=\"https://www.instagram.com/\"><i class=\"fab fa-instagram\"></i></a>\n");
      out.write("                    <a href=\"https://www.linkedin.com/\"><i class=\"fab fa-linkedin-in\"></i></a>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"section1\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"Home.jsp\">Home</a></li>\n");
      out.write("                    <li><a href=\"View_products.jsp\" > Products </a></li>\n");
      out.write("                    <li><a href=\"View_mobiles.jsp\"> Mobiles </a></li>\n");
      out.write("                    <li><a href=\"View_laptops.jsp\"> Laptops </a></li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div style=\"display: inline-block; width: 70%; margin-left: 10%\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "View_products.jsp", out, false);
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
