<%-- 
    Document   : main
    Created on : Apr 26, 2017, 5:05:18 PM
    Author     : Nexor
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="org.apache.http.cookie.CookieSpec"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            out.write("You're in processAuth");
            boolean gotCookie = request.getParameter("matricula") == null && request.getParameter("senha") == null;
            String matr = null;
            String senha = null;
            if (gotCookie) {
                List<Cookie> cookies = Arrays.asList(request.getCookies());
                for (Cookie c : cookies) {
                    if (c.getName().equals("matricula")) {
                        matr = c.getValue();
                    } else if (c.getName().equals("senha")) {
                        senha = c.getValue();
                    }
                }
            } else {
                matr = request.getParameter("matricula");
                senha = request.getParameter("senha");
                Cookie cMatr = new Cookie("matricula", matr);
                cMatr.setMaxAge(60 * 30);//30 min -- ate la ja fiz o eterno
                Cookie cSenha = new Cookie("senha", senha);
                response.addCookie(cMatr);
                cSenha.setMaxAge(60 * 30);//30 min -- ate la ja fiz o eterno
                response.addCookie(cSenha);
            }
            response.setHeader("matricula", matr);
            response.setHeader("senha", senha);
            response.sendRedirect("displayHoje.jsp");
        %>
    </body>
</html>