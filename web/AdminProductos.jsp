<%-- 
    Document   : AdminProductos
    Created on : May 6, 2015, 9:54:03 AM
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
        <title>Administrar Productos</title>
        
    </head>
    <body>
        <%
            if (session.getAttribute("usuario") != null) {
                out.println(session.getAttribute("usuario")
                        + "<br/><a href='Salir'/>Salir</a><br/>");
                if (session.getAttribute("rol").equals("admin")) {
        %>
        <a href="Admin.jsp"/>Volver a menú administrador</a><br/><br/>
        <h1>Administrar Productos</h1>
        <h2>Agregar Producto</h2>
         <form action="AdministrarUsuario" method="post">
                ProductoID:  <input type="text" name="agrProductoID" maxlength="6" required></input><br/>
                Nombre:      <input type="text" name="agrNombreProducto" required></input><br/>
                Descripción: <input type="text" name="agrDescripcionProducto" required></input><br/>
                Precio:      <input type="number" name="agrPrecioProducto" value="0.00" step="0.01" required></input> Pesos<br/>
                             <input type="hidden" name="opcion" value="agregarProducto"></input>
                             <input type="submit" value="Agregar"></input>
        </form>
        <h2>Modificar Producto</h2>
        <form action="AdministrarUsuario" method="post">
                <div id="listaProductosModificar"></div>
                <div id="infoProductoModificar"></div>
            </form>
        <h2>Eliminar Producto</h2>
        <form action="AdministrarUsuario" method="post">
                <div id="listaProductosEliminar"></div>
                <div id="infoProductoEliminar"></div>
        </form>
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
