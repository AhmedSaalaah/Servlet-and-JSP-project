package org.apache.jsp.View_005fproducts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class HOme_005ftrial_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title> Home Page </title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div style=\"background-color: lightgray; height: 30%; padding-top: 2%;padding-bottom: 2%\"> \n");
      out.write("                <a href=\"HOme_trial.jsp\" style=\"color: white ; font-size: 25px\"> Home </a>\n");
      out.write("                &nbsp; &nbsp; &nbsp;<a href=\"View_products.jsp\"style=\"font-size: 25px; color: white\"> Products </a>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <div>\n");
      out.write("            <div style=\"background-color: lightblue; display: inline-block;width: 15%; height: 50% ; padding: 1% 1% 1% 1%\">\n");
      out.write("\n");
      out.write("                <h2 style=\"color: white\"> Categories </h2>\n");
      out.write("                <a href=\"View_mobiles.jsp\" style=\"color: white ; font-size: 25px\"> Mobiles </a><br>\n");
      out.write("                <a href=\"View_laptops.jsp\"style=\"font-size: 25px; color: white\"> Laptops </a>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <form action=\"Search_price.jsp\" method=\"GET\">\n");
      out.write("                   \n");
      out.write("                    \n");
      out.write("                <label style=\"color: white ; font-size: 25px\"> Select price range </label> <br>\n");
      out.write("\n");
      out.write("                <input type=\"range\" id=\"rangeInput\" name=\"rangeInput\" min=\"0\" max=\"20000\" value=\"0\"\n");
      out.write("                       oninput=\"amount.value=rangeInput.value\" formaction=\"View_products.jsp?price=rangeInput.value\">                                                       \n");
      out.write("\n");
      out.write("                <output id=\"amount\" name=\"amount\" for=\"rangeInput\" style=\"color: white\"> 0 </output> \n");
      out.write("                <input type =\"submit\" value=\"Search\"></form>\n");
      out.write("                \n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <form action=\"Search_name.jsp\" method=\"GET\">\n");
      out.write("                    Search By Name: <input type=\"text\" name=\"Name\">\n");
      out.write("                    <input type =\"submit\" value=\"Search\"></form>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div style=\"display: inline-block; width: 70%; margin-left: 10%\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "View_products.jsp", out, false);
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <footer style=\"background-color: black\"></footer>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
