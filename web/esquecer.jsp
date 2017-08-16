<%-- 
    Document   : auth
    Created on : Apr 26, 2017, 7:08:26 PM
    Author     : Nexor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html background="http://eskipaper.com/images/red-textured-background-1.jpg">
    <%
        if (request.getHeader("User-Agent").indexOf("Mobile") != -1) {
//            out.write("<link rel=\"stylesheet\" href=\"http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.css\">\n"
//                    + "<script src=\"http://code.jquery.com/jquery-1.10.2.min.js\"></script>\n"
//                    + "<script src=\"http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js\"></script>");
        }
    %>
    <head>
        <meta name="viewport" http-equiv="Content-Type" content="width=device-width; initial-scale=1; text/html; charset=UTF-8">
        <title>Posso Faltar?</title>
    </head>
    <body>
        <%
            Cookie[] cookies = request.getCookies();
            Cookie cU = null;
            Cookie cS = null;
            for (Cookie c : cookies) {
                if (c.getName().equals("matricula")) {
                    cU = c;
                } else if (c.getName().equals("senha")) {
                    cS = c;
                }
            }
            if (cU != null && cS != null) {
                cU.setMaxAge(0);
                cS.setMaxAge(0);
                response.addCookie(cU);
                response.addCookie(cS);
                response.sendRedirect("auth.jsp");
            }
        %>
    </body> 
</html>
