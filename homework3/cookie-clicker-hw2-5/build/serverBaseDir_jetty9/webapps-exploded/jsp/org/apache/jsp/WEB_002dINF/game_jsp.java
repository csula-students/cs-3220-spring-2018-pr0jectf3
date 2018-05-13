package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class game_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>McNugget Clicker</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        .button-buy button{\r\n");
      out.write("            background-color: firebrick;\r\n");
      out.write("            border: 2px solid wheat;\r\n");
      out.write("            color: white;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 100px;\r\n");
      out.write("            display: block;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .button-buy button:hover{\r\n");
      out.write("            background-color: firebrick;\r\n");
      out.write("            transform: translateX(20px);\r\n");
      out.write("            color: ghostwhite;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .button-buy button:hover .tooltiptext {\r\n");
      out.write("            visibility: visible;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .button-buy button:active{\r\n");
      out.write("            transform: translateY(10px);\r\n");
      out.write("            background-color: wheat;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .story{\r\n");
      out.write("            background-color: transparent;\r\n");
      out.write("            color: wheat;\r\n");
      out.write("            overflow-y: scroll;\r\n");
      out.write("            margin-right: 500px;\r\n");
      out.write("            margin-left: 525px;\r\n");
      out.write("            margin-bottom: 50px;\r\n");
      out.write("            margin-top: 10px;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .title{\r\n");
      out.write("            border: none;\r\n");
      out.write("            margin: 20px;\r\n");
      out.write("            margin-left: 450px;\r\n");
      out.write("            color: wheat;\r\n");
      out.write("            font-family: fantasy;\r\n");
      out.write("            font-size: 30pt;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        .jj{\r\n");
      out.write("            display: flex;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .count{\r\n");
      out.write("            margin-left: 450px;\r\n");
      out.write("            font-size: 75pt;\r\n");
      out.write("            font-family: fantasy;\r\n");
      out.write("            color: wheat;\r\n");
      out.write("            border: 0;\r\n");
      out.write("            backface-visibility: hidden;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .clicker{\r\n");
      out.write("            background-size: 500px 500px;\r\n");
      out.write("            background-color: firebrick;\r\n");
      out.write("            height: 500px;\r\n");
      out.write("            width: 500px;\r\n");
      out.write("            display: block;\r\n");
      out.write("            margin-left: 250px;\r\n");
      out.write("            background-repeat: no-repeat;\r\n");
      out.write("            border: 0;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .clicker:active{\r\n");
      out.write("            transform: translateY(5px);\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .body{;\r\n");
      out.write("            background-color: aqua;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .top-row{\r\n");
      out.write("            display: flex;\r\n");
      out.write("            justify-content: space-between;\r\n");
      out.write("            font-family: cursive;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .tooltiptext {\r\n");
      out.write("            visibility: hidden;\r\n");
      out.write("            width: 320px;\r\n");
      out.write("            height: 85px;\r\n");
      out.write("            background-color: darkgray;\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            border-radius: 6px;\r\n");
      out.write("            padding: 5px 0;\r\n");
      out.write("\r\n");
      out.write("            /* Position the tooltip */\r\n");
      out.write("            position:absolute;\r\n");
      out.write("            z-index: 1;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .cost{\r\n");
      out.write("            display: flex;\r\n");
      out.write("            justify-content: flex-end;\r\n");
      out.write("            margin-bottom: 5px;\r\n");
      out.write("            color: yellow;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    <script>\r\n");
      out.write("        generators = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${generator}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(";\r\n");
      out.write("        for(i = 0 ; i < generators.length ; i++){\r\n");
      out.write("            generators[i].type = 'generators';\r\n");
      out.write("            generators[i].unlockValue = generators[i].unlockAt;\r\n");
      out.write("            generators[i].quantity = 0;\r\n");
      out.write("            delete generators[i].unlockAt;\r\n");
      out.write("            delete generators[i].id;\r\n");
      out.write("        }\r\n");
      out.write("        stories = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${stories}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(";\r\n");
      out.write("        for(i = 0 ; i < stories.length ; i++){\r\n");
      out.write("            stories[i].triggeredAt = stories[i].triggerAt;\r\n");
      out.write("            stories[i].state = 'hidden';\r\n");
      out.write("            delete stories[i].triggerAt;\r\n");
      out.write("            delete stories[i].id;\r\n");
      out.write("        }\r\n");
      out.write("        var backInfo = {};\r\n");
      out.write("        backInfo.counter = 0;\r\n");
      out.write("        backInfo.generators = generators;\r\n");
      out.write("        backInfo.story = stories;\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class = \"body\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class = \"title\">\r\n");
      out.write("    <h1> McNugget Clicker</h1>\r\n");
      out.write("</div>\r\n");
      out.write("<main>\r\n");
      out.write("    <div class = \"story\">\r\n");
      out.write("        <game-story-book></game-story-book>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class =\"jj\">\r\n");
      out.write("\r\n");
      out.write("        <game-generator data-id=\"0\"></game-generator>\r\n");
      out.write("        <game-generator data-id=\"1\"></game-generator>\r\n");
      out.write("        <game-generator data-id=\"2\"></game-generator>\r\n");
      out.write("        <game-generator data-id=\"3\"></game-generator>\r\n");
      out.write("        <game-generator data-id=\"4\"></game-generator>\r\n");
      out.write("        <game-generator data-id=\"5\"></game-generator>\r\n");
      out.write("        <game-generator data-id=\"6\"></game-generator>\r\n");
      out.write("\r\n");
      out.write("        <div class = \"function\">\r\n");
      out.write("            <game-button></game-button>\r\n");
      out.write("            <game-counter></game-counter>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</main>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script type = \"text/javascript\" src= \"app.bundle.js\">\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
