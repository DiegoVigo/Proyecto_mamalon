<%-- 
    Document   : AdminTienda
    Created on : May 12, 2015, 4:28:37 PM
    Author     : jviveros
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Language" content="ES">
        <meta charset="ISO-8859-1">
        <title>Administrar Tienda</title>
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
    <h1>Administrar Tiendas</h1>
    <h2>Mover producto a tienda.</h2>

    <form action="FuncionesAdministrador" method="post">
        <div id="listaTienda"></div>
        <div id="listaTiendaProducto"></div>
        <div id="infoProductoTienda"></div>
        Cajas a pasar:     <input type="number" name="movTiendaCajas" value="0" required></input> Caja(s)<br/>
        Unidades por caja: <input type="number" name="movTiendaCajau" value="0" required></input> Unidad (es)<br/>
        Cantidad Unitario: <input type="number" name="movTiendaUnit" value="0" required></input> Unidad (es)<br/>
        <input type="hidden" name="movTiendaUsuarioID" maxlength="6" value="<%=usuario%>"></input><br/>
        <input type="hidden" name="opcion" value="moverTienda"></input>
        <input type="submit" value="Mover a Tienda"></input>
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
