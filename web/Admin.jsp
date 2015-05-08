<%-- 
    Document   : Admin
    Created on : Apr 28, 2015, 10:36:19 AM
    Author     : jviveros
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Language" content="ES">
        <meta charset="ISO-8859-1">
        <title>Administrador</title>
        <script src="js/Admin.js"></script>
    </head>
    <body>
        <%
            if (session.getAttribute("usuario") != null) {
                out.println(session.getAttribute("usuario")
                        + "<br/><a href='Salir'/>Salir</a><br/>");
                if (session.getAttribute("rol").equals("admin")) {
        %>
        <h1>Administrador</h1>
        <a href="AdminUsuarios.jsp"/>Administrar Usuarios</a><br>
        <a href="AdminProductos.jsp"/>Administrar Productos</a><br>
        <a href="AdminCompras.jsp"/>Administrar Compras</a><br>
        <a href="Inventario"/>Inventario</a><br>
        <a href="VentasAdmin"/>Ventas</a><br>
        <%
        } else {
        %>
        <h1>No tienes acceso a esta p�gina</h1>
        <a href="index.jsp"/>Iniciar Sesi�n</a><br/><br/>
        <%
            }
        } else {
        %>
        <h1>No tienes acceso a esta p�gina</h1>
        <a href="index.jsp"/>Iniciar Sesi�n</a><br/><br/>
        <%    }
        %>
    </body>
</html>
