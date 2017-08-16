<%-- 
    Document   : redirect
    Created on : Apr 26, 2017, 7:59:15 PM
    Author     : Nexor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
//            out.write("teste");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
//            response.sendRedirect("/index.htm");
        %>
    </body>
</html>
