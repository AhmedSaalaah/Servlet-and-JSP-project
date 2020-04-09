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

public final class orderfailed_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      out.write("      \r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css1/bootstrap.min.css\">\r\n");
      out.write("   \r\n");
      out.write("  \r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css1/all.css\">\r\n");
      out.write("   \r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css1/flaticon.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css1/themify-icons.css\">\r\n");
      out.write("   \r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css1/style.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css1/all.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css1/hider.css\">\r\n");
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
      out.write("            <div class=\"section1\" >\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a href=\"#\">Home</a></li>\r\n");
      out.write("                    <li><a href=\"#\">About Us</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Services</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Contact Us</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("               \r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write(" \r\n");
      out.write("\n");
      out.write("\n");
      out.write("            <h1 class=\"page\" >Your Credit Limit Is not enough </h1>\n");
      out.write("            \n");
      out.write("         </div>\n");
      out.write("        </body>\n");
      out.write("        </html>\n");
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
