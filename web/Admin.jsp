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
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/Admin.js"></script>
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
        <a href="AdminAlmacen.jsp"/>Administrar Almacenes</a><br>
        <a href="AdminTienda.jsp"/>Administrar Tiendas</a><br>
        <a href="VentasAdmin"/>Ventas</a><br>
        <%
        } else {
        %>
        <h1>No tienes acceso a esta página</h1>
        <a href="index.jsp"/>Iniciar Sesión</a><br/><br/>
        <%
            }
        } else {
        %>
        <h1>No tienes acceso a esta página</h1>
        <a href="index.jsp"/>Iniciar Sesión</a><br/><br/>
        <%    }
        %>
    </body>
</html>
