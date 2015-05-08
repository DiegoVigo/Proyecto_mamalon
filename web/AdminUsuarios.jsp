<%-- 
    Document   : AdminUsuarios
    Created on : Apr 28, 2015, 12:50:13 PM
    Author     : jviveros
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <script type="text/javascript" src="js/jquery.js"></script>
            <script type="text/javascript" src="js/Admin.js"></script>
            <title>Administrar Usuarios</title>
    </head>
    <body>
         <%
            if (session.getAttribute("usuario") != null) {
                out.println(session.getAttribute("usuario")
                        + "<br/><a href='Salir'/>Salir</a><br/>");
                if (session.getAttribute("rol").equals("admin")) {
        %>
        <a href="Admin.jsp"/>Volver a menú administrador</a><br/><br/>
        <h1>Administración de usuarios</h1>
        <div>
            <h2>Agregar nuevo vendedor.</h2>
            <form action="AdministrarUsuario" method="post">
                UserID: <input type="text" name="agrUserID" maxlength="9" required></input><br/>
                Nombre: <input type="text" name="agrNombreUser" required></input><br/>
                Rol: <select name="agrRol" required>
                     <option value="user">user</option>
                     <option value="almacen">almacen</option>
                     <option value="admin">admin</option>
                </select><br/>
                <div id="listaSucursal"></div>
                Contraseña: <input type="password" name="agrContrasena" required></input><br/>
                Repetir Contraseña: <input type="password" name="agrContrasena1" required></input><br/>
                <input type="hidden" name="opcion" value="agregarUsuario"></input>
                <input type="submit" value="Agregar"></input>
            </form>
        </div>
        <br/>
        <br/>
        <div>
            <h2>Eliminar vendedor.</h2>
            <form action="AdministrarUsuario" method="post">
                <div id="listaNombreUsuariosEliminar"></div>
                <div id="infoUsuarioEliminar"></div>
                <input type="hidden" name="opcion" value="eliminarUsuario"></input>
                <input type="submit" value="Eliminar"></input>
            </form>
        </div>
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
