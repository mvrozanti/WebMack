package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Arrays;
import mackApp.TIA.TIAController;

public final class displayHoje_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"all.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head\n");
      out.write("    <font \n");
      out.write("        <body bgcolor=\"#4d0ab2\">\n");
      out.write("        ");

            List<Cookie> cookies = Arrays.asList(request.getCookies());
//            String matricula = request.getHeader("matricula");
//            String senha = request.getHeader("senha");
            String matricula = null;
            String senha = null;
            for (Cookie c : cookies) {
                if (c.getName().equals("matricula")) {
                    matricula = c.getValue();
                } else if (c.getName().equals("senha")) {
                    senha = c.getValue();
                }
            }
            TIAController tiac = TIAController.getController(matricula, senha);
            tiac.getSchedule();
            tiac.getFrequency();
            String htmlForToday = tiac.getHTML();
            if (htmlForToday == null || htmlForToday.isEmpty()) {
                out.write("got no header");
            } else {
                Cookie cMatr = new Cookie("usuario", matricula);
                cMatr.setMaxAge(Integer.MAX_VALUE);
                Cookie cSenha = new Cookie("senha", senha);
                response.addCookie(cMatr);
                cSenha.setMaxAge(Integer.MAX_VALUE);
                response.addCookie(cSenha);
                out.write(htmlForToday);
            }
        
      out.write("\n");
      out.write("        <!--<h1>Cookies salvos</h1>-->\n");
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
