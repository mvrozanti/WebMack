<%-- 
    Document   : displayHoje
    Created on : Apr 26, 2017, 5:34:07 PM
    Author     : Nexor
--%>

<%@page import="mackApp.backend.TIAController"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Posso Faltar?</title>
        <%
//            if (request.getHeader("User-Agent").contains("Mobile")) {
//                out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"mobile.css\"/>");
//            } else {
            out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"global.css\"/>");
//            }
        %>
    </head>
    <div id="header">
        <div class="logo">
            <a href="#">
                Web<span>Mack</span>
            </a>
        </div>
    </div>
    <body>
        <div id="container">
            <div class="sidebar">
                <ul id="nav">
                    <li class="horarios-ico"><a href="#">Horários*</a></li>
                    <li class="faltas-ico"><a href="#">Faltas*</a></li>
                    <li class="notas-ico"><a href="#">Notas*</a></li>
                    <li class="tarefas-ico"><a href="#">Tarefas*</a></li>
                    <li class="comidas-ico"><a href="#">Comidas/Delivery*</a></li>
                    <li class="suporte-ico"><a href="#">Suporte*</a></li>
                    <li class="config-ico"><a href="#">Configurações*</a></li>
                </ul>
                <form action="esquecer.jsp" method="POST">
                    <input class="forget" type="submit" value="Esquecer de mim :'(">
                </form>
                *: not implemented yet!
            </div>
            <div class="content">
                um ragu!
            </div>
        </div>
        <%
//            List<Cookie> cookies = Arrays.asList(request.getCookies());
//            String matricula = null;
//            String senha = null;
//            for (Cookie c : cookies) {
//                if (c.getName().equals("matricula")) {
//                    matricula = c.getValue();
//                } else if (c.getName().equals("senha")) {
//                    senha = c.getValue();
//                }
//            }
//
//            TIAController tiac = new TIAController(matricula, senha);
//            tiac.getSchedule();
//            tiac.getFrequency();
//            String htmlForToday = tiac.getHTML();
//            if (htmlForToday == null || htmlForToday.isEmpty()) {
//                out.write("got no header");
//            } else {
//                Cookie cMatr = new Cookie("matricula", matricula);
//                cMatr.setMaxAge(Integer.MAX_VALUE);
//                Cookie cSenha = new Cookie("senha", senha);
//                response.addCookie(cMatr);
//                cSenha.setMaxAge(Integer.MAX_VALUE);
//                response.addCookie(cSenha);
//                out.write(htmlForToday);
//            }
//            out.write("<br><br>");
%>
        <!--<h1>Cookies salvos</h1>-->
    </body>
</html>
