package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_002devents_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Events</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<h1>Hello events servlet!</h1>\r\n");
      out.write("<h1>Incremental Game</h1>\r\n");
      out.write("<link rel='stylesheet' type='text/css' href='/app.css'/>\r\n");
      out.write("<p>\r\n");
      out.write("<h4>Event Name:</h4>\r\n");
      out.write("<form method='POST' action=\"\">\r\n");
      out.write("    <input name='name' type=\"text\" id=\"event name\">\r\n");
      out.write("    </p>\r\n");
      out.write("    <p>\r\n");
      out.write("    <h4>Event Description:</h4>\r\n");
      out.write("    <input name='description' type=\"text\" id=\"event description\"></p>\r\n");
      out.write("    <p>\r\n");
      out.write("    <h4>Trigger At:</h4>\r\n");
      out.write("    <input name='triggerAt' type=\"text\" id=\"trigger at\">\r\n");
      out.write("    <button>Add/Edit</button>\r\n");
      out.write("</form>\r\n");
      out.write("</p>\r\n");
      out.write("<table>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td>Name</td>\r\n");
      out.write("        <td>Description</td>\r\n");
      out.write("        <td>Trigger At</td>\r\n");
      out.write("        <td>Edit</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("\r\n");
      out.write("    <c:forEach items = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${entries}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var = \"entry\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${entry.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("            <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${entry.getDescription()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("            <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${entry.getTriggerAt()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("            <td>eed</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </c:forEach>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
