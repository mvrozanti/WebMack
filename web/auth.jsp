<%-- 
    Document   : auth
    Created on : Apr 26, 2017, 7:08:26 PM
    Author     : Nexor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html background="http://eskipaper.com/images/red-textured-background-1.jpg">
    <meta name="viewport" http-equiv="Content-Type" content="width=device-width; initial-scale=1; text/html; charset=UTF-8">
    <title>Posso Faltar?</title>
    <%
        if (request.getHeader("User-Agent").indexOf("Mobile") != -1) {
//            out.write("<link rel=\"stylesheet\" href=\"http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.css\">\n"
//                    + "<script src=\"http://code.jquery.com/jquery-1.10.2.min.js\"></script>\n"
//                    + "<script src=\"http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js\"></script>");
        }
    %>
    <body>
        <%
            Cookie[] cookies = request.getCookies();
            boolean gotCookieUsuario = false;
            boolean gotCookieSenha = false;
            for (Cookie c : cookies) {
                if (c.getName().equals("matricula")) {
                    gotCookieUsuario = true;
                } else if (c.getName().equals("senha")) {
                    gotCookieSenha = true;
                }
            }
            if (gotCookieUsuario && gotCookieSenha) {
                response.sendRedirect("processAuth.jsp");
            }
        %>
        <form action="processAuth.jsp" method="POST">
            <p>Matrícula:<input type="tel" name="matricula"><p>
            <p>Senha: <input type="password" name="senha"></p>
            <input type="submit" value="Submit">
        </form>
    </body> 
</html>
