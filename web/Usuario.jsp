<%-- 
    Document   : Usuario
    Created on : Apr 28, 2015, 11:33:53 AM
    Author     : jviveros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
    </head>
    <body>
         <%
            if (session.getAttribute("usuario") != null) {
                out.println(session.getAttribute("usuario")
                        + " </span><br/><a href='Salir'/>Salir</a><br/>");
                if (session.getAttribute("rol").equals("user")) {
        %>
        <h1>Usuario</h1>
        <%
        } else {
        %>
        <h1>No tienes acceso a esta página</h1>
        <%
            }
        } else {
        %>
        <h1>No tienes acceso a esta página</h1>
        <%    }

        %>

    </body>
</html>
