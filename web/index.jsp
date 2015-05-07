<%-- 
    Document   : index
    Created on : Apr 28, 2015, 11:16:17 AM
    Author     : jviveros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión</title>
    </head>
    <body>
        <div>
            <form action="Login" method="post">
                Usuario   : <input type="text" name="usuario"><br>
                Contraseña: <input type="password" name="contrasena"><br>
                <a href="CambiarContrasena.jsp"/>Olvidó su contraseña</a><br>
                <input type="submit" value="Entrar">
            </form>
        </div>
    </body>
</html>
