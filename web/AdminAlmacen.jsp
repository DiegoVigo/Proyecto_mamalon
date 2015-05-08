<%-- 
    Document   : AdminAlmacen
    Created on : May 8, 2015, 10:04:34 AM
    Author     : jviveros
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Language" content="ES">
        <meta charset="ISO-8859-1">
        <title>Administrar Almacen</title>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/Admin.js"></script>
    </head>
    <body>
        <%
            if (session.getAttribute("usuario") != null) {
                out.println(session.getAttribute("usuario")
                        + "<br/><a href='Salir'/>Salir</a><br/>");
                if (session.getAttribute("rol").equals("admin")) {
                    String usuario = session.getAttribute("usuario").toString();
        %>
        <a href="Admin.jsp"/>Volver a menú administrador</a><br/><br/>
    <h1>Administrar Almacenes</h1>
    <h2>Mover producto entre almacenes.</h2>

    <form action="FuncionesAdministrador" method="post">
        <div id="listaAlmacenFrom"></div>
        <div id="infoProductoAlmacen"></div>
        Cajas a pasar:     <input type="number" name="movAlmacenCajas" value="0" required></input> Caja(s)<br/>
        Unidades por caja: <input type="number" name="movAlmacenCajau" value="0" required></input> Unidad (es)<br/>
        Cantidad Unitario: <input type="number" name="movAlmacenUnit" value="0" required></input> Unidad (es)<br/>
        <input type="hidden" name="movAlmacenUsuarioID" maxlength="6" value="<%=usuario%>"></input><br/>
        <input type="hidden" name="opcion" value="moverAlmacen"></input>
        <input type="submit" value="Mover a Almacen"></input>
    </form>

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
