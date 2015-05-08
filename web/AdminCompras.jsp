<%-- 
    Document   : AdminCompras
    Created on : May 6, 2015, 5:16:41 PM
    Author     : jviveros
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Language" content="ES">
        <meta charset="ISO-8859-1">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/Admin.js"></script>
        <title>Administrar Compras</title>

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
    <h1>Administrar Compras</h1>
    <h2>Agregar Compra</h2>
    <form action="AdministrarUsuario" method="post">
        <input type="hidden" name="agrCompraUsuarioID" maxlength="6" value="<%=usuario%>"></input><br/>
        <div id="listaProductos"></div>
        Precio compra:     <input type="number" name="agrCompraPrecio_c" value="0.00" step="0.01" required></input> Pesos<br/>
        Precio venta:      <input type="number" name="agrCompraPrecio_v" value="0.00" step="0.01" required></input> Pesos<br/>
        Cantidad caja:     <input type="number" name="agrCompraCantidadCaja" value="0" required></input> Caja(s)<br/>
        Unidades por caja: <input type="number" name="agrCompraCantidadCajau" value="0" required></input> Caja(s)<br/>
        Cantidad unidades: <input type="number" name="agrCompraCantidadUnit" value="0" required></input> unidad(es)<br/>
        <input type="hidden" name="opcion" value="agregarCompra"></input>
        <input type="submit" value="Agregar"></input>
    </form>
    <%
    } else {
    %>
    <h1>No tienes acceso a ésta página</h1>
    <a href="index.jsp"/>Iniciar Sesión</a><br/><br/>
    <%
        }
    } else {
    %>
    <h1>No tienes acceso a ésta página</h1>
    <a href="index.jsp"/>Iniciar Sesión</a><br/><br/>
    <%    }
    %>
</body>
</html>
